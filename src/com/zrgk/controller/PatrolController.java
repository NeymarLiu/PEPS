package com.zrgk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.FuzzyPartPTaskParams;
import com.zrgk.pojo.InformationStatisticsParams;
import com.zrgk.pojo.PatrolFlawPojo;
import com.zrgk.pojo.PatrolQueryPojo;
import com.zrgk.pojo.PatrolTaskPojo;
import com.zrgk.pojo.PatrolUserPojo;
import com.zrgk.pojo.PolePojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.LogService;
import com.zrgk.service.PatrolService;
import com.zrgk.util.DownloadUtils;
import com.zrgk.util.PartPage;

/**
 * @author liucan
 * @version 2016年11月23日16:15:50
 * */
@Controller
public class PatrolController {
	@Autowired
	private PatrolService patrolService;
	@Autowired
	private LogService logService;
	public void setPatrolService(PatrolService patrolService) {
		this.patrolService = patrolService;
	}
	public PatrolService getPatrolService() {
		return patrolService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public LogService getLogService() {
		return logService;
	}
	//展示所有巡检任务信息
	@RequestMapping("/getAllPatrol.action")
	public String getAllPatrolTask(HttpServletRequest request,FuzzyPartPTaskParams fptp,String nowPage){
		//当前页码	
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		//添加当前用户
		fptp.setU_id(((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		//得到总记录数
		int count =patrolService.getAllPatrolTaskCount(fptp);
		PartPage partPage=patrolService.getPartPage(count, page);
		if(count!=0){
			fptp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			fptp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			request.setAttribute("ptaskList", patrolService.getAllPatrolTask(fptp));
		}
		request.setAttribute("page", partPage);
		//参数回显
		request.setAttribute("fptp", fptp);
		return "xunjian/module1/index.jsp";
	}
	//跳转到添加巡检任务页面
	@RequestMapping("/toPatrolTask.action")
	public String toPatrolTask(HttpServletRequest request){
		String s=patrolService.getMaxTaskID();
		//组装巡检任务编号
		if(s==null){
			s="1";
		}else{
			s=(Integer.parseInt(s)+1)+"";
		}
		String str="";
		if(s.length()<4){
			for(int i=0;i<4-s.length();i++){
				str+="0";
			}
		}
		//组装任务编号
		request.setAttribute("rwid", "XJ"+str+s);
		//线路信息
		request.setAttribute("lineList", patrolService.getAllLine());
		request.setAttribute("mark",request.getAttribute("mark"));
		System.out.println(request.getParameter("mark"));
		//巡检员信息
		request.setAttribute("patrolList", patrolService.getPatrolPeople());
		return "xunjian/module1/add.jsp";
	}
	//根据线路id得到关联的塔杆信息
	//@ResponseBody
	@RequestMapping("/getPoleByLine.action")
	public void getPoleByLine(int lid,HttpServletResponse response) throws IOException{
		//得到对应线路的塔杆
		List<PolePojo>pList=patrolService.getPojoByLine(lid);
		Gson gson=new Gson();
		String poles=gson.toJson(pList).toString();
		response.getWriter().println(poles);
	}
	//向数据库添加巡检任务，及执行任务的巡检员
	@RequestMapping("/addPatrolTask.action")
	public String addPatrolTask(PatrolTaskPojo ptp,HttpServletRequest request,HttpServletResponse response,int[] u_id) throws ServletException, IOException{
		if(u_id==null){
			//待分配状态
			ptp.setP_state(1);
		}else {
			//已分配状态
			ptp.setP_state(2);
		}
		//插入巡检任务
		ptp.setP_issued_id(((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		String mark=patrolService.addPatrolTask(ptp)+"";
		//根据线路编号获取巡检任务的id
		int p_id=patrolService.getPidByPcode(ptp.getP_num());
		PatrolUserPojo pup=new PatrolUserPojo();
		pup.setP_id(p_id);
		//循环插入此巡检任务的巡检员
		if(u_id!=null){
			for (int i = 0; i < u_id.length; i++) {
				pup.setU_id(u_id[i]);
				patrolService.addTaskUser(pup);
			}
		}
		//循环插入巡检任务对于的塔杆记录
		List<PolePojo>list=patrolService.getTaskPole(ptp);
		for (int i = 0; i < list.size(); i++) {
			PatrolFlawPojo pfp=new PatrolFlawPojo();
			pfp.setP_id(ptp.getP_id());
			pfp.setPf_pole(list.get(i).getPole_id());
			patrolService.addTaskPole(pfp);
		}
		logService.insertLog("下发巡检任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		request.setAttribute("mark",1);
		return "toPatrolTask.action";
	}
	//查看巡检任务详情
	@RequestMapping("/lookPTask.action")
	public String lookPTask(int pid,HttpServletRequest request){
		PatrolTaskPojo pTask=patrolService.getOnePatrolTask(pid);
		request.setAttribute("pTask", pTask);
		return "xunjian/module1/look.jsp";
	}
	//跳转到分配任务页面
	@RequestMapping("/toAssignTask.action")
	public String toAssignTask(HttpServletRequest request,int p_id){
		List<UserPojo>list=patrolService.getPatrolPeople();
		request.setAttribute("puList",list);
		request.setAttribute("p_id",p_id);
		return "xunjian/module1/share.jsp";
	}
	//添加任务执行人员
	@RequestMapping("/updataAssignTask.action")
	public String updataAssignTask(HttpServletRequest request,int [] u_id,int p_id){
		PatrolUserPojo pup=new PatrolUserPojo();
		pup.setP_id(p_id);
		if(u_id!=null){
			for (int i = 0; i < u_id.length; i++) {
				pup.setU_id(u_id[i]);
				patrolService.addTaskUser(pup);
			}
		}
		PatrolTaskPojo ptp=new PatrolTaskPojo();
		ptp.setP_id(p_id);
		ptp.setP_state(2);
		int mark=patrolService.updatePaskState(ptp);
		logService.insertLog("分配巡检任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		request.setAttribute("mark", mark);
		return "xunjian/module1/share.jsp";
	}
	//取消任务
	@RequestMapping("/cancleTask.action")
	public String cancleTask(HttpServletRequest request,int pid)  {
		patrolService.cancleTask(pid);
		logService.insertLog("取消巡检任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		return "getAllPatrol.action";
	}
	//跳转到更改巡检任务详情
	@RequestMapping("/toUpdatePTask.action")
	public String toUpdatePTask(int pid,HttpServletRequest request){
		PatrolTaskPojo pTask=patrolService.getOnePatrolTask(pid);
		request.setAttribute("pTask", pTask);
		//所有线路详情
		request.setAttribute("lineList", patrolService.getAllLine());
		//得到此线路下的塔杆
		List<PolePojo>pList=patrolService.getPojoByLine(pTask.getP_lid());
		request.setAttribute("poles", pList);
		//所有的巡检员
		request.setAttribute("patrolList", patrolService.getPatrolPeople());
		return "xunjian/module1/update.jsp";
	}
	//更改巡检任务详情
	@RequestMapping("/updatePTask.action")
	public String updatePTask(PatrolTaskPojo ptp,HttpServletRequest request,HttpServletResponse response,int[] u_id){
		if(u_id==null){
			//待分配状态
			ptp.setP_state(1);
		}else {
			//已分配状态
			ptp.setP_state(2);
		}
		//更改业务详情
		patrolService.updatePTask(ptp);
		//删除任务对应的塔杆
		patrolService.deletePTaskFlaw(ptp.getP_id());
		//循环插入巡检任务对于的塔杆记录
		List<PolePojo>list=patrolService.getTaskPole(ptp);
		for (int i = 0; i < list.size(); i++) {
			PatrolFlawPojo pfp=new PatrolFlawPojo();
			pfp.setP_id(ptp.getP_id());
			pfp.setPf_pole(list.get(i).getPole_id());
			patrolService.addTaskPole(pfp);
		}
		PatrolUserPojo pup=new PatrolUserPojo();
		pup.setP_id(ptp.getP_id());
		//循环插入此巡检任务的巡检员
		if(u_id!=null){
			for (int i = 0; i < u_id.length; i++) {
				pup.setU_id(u_id[i]);
				patrolService.addTaskUser(pup);
			}
		}
		logService.insertLog("修改巡检任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		request.setAttribute("mark", 1);
		return "xunjian/module1/update.jsp";
	}
	
	
	//================    巡检任务执行与回执    =======================
	@RequestMapping("/getAllPTask.action")
	public String getAllPTask(HttpServletRequest request,FuzzyPartPTaskParams fptp,String nowPage){
		//当前页码	
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		//添加当前用户
		fptp.setU_id(((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		//得到总记录数
		int count =patrolService.getAllPTaskCount(fptp);
		PartPage partPage=patrolService.getPartPage(count, page);
		if(count!=0){
			fptp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			fptp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			request.setAttribute("ptaskList", patrolService.getAllPTask(fptp));
		}
		request.setAttribute("page", partPage);
		//参数回显
		request.setAttribute("fptp", fptp);
		request.setAttribute("mark", request.getAttribute("mark"));
		return "xunjian/module2/index.jsp";
	}
	//@ResponseBody
	@RequestMapping("/startPTask.action")
	public String startPTask(PatrolTaskPojo ptp,HttpServletRequest request) throws IOException{
		//将任务状态改为执行中
		ptp.setP_state(3);
		int mark=patrolService.updatePaskState(ptp);
		//添加任务执行时间
		ptp.setP_start_time(new Date());
		patrolService.updatePStartTime(ptp);
		request.setAttribute("mark", mark);
		logService.insertLog("执行巡检任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		return "getAllPTask.action";
	}
	//跳转到回执录入
	@RequestMapping("/toReceiptPTask.action")
	public String toReceiptPTask(int p_id,HttpServletRequest request){
		//根据任务id 得到任务详情
		PatrolTaskPojo pTask=patrolService.getOnePatrolTask(p_id);
		//根据任务
		request.setAttribute("pTask", pTask);
		request.setAttribute("flawList", patrolService.getPFlaw());
		return "xunjian/module2/enter.jsp";
	}
	//回执录入
	@RequestMapping("/receiptPTask.action")
	public void receiptPTask(HttpServletRequest request,HttpServletResponse response,PatrolFlawPojo pfp) throws IOException{
		logService.insertLog("回执录入巡检任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		response.getWriter().println(patrolService.updatePoleFlaw(pfp));
	}
	//ajax异步返回消缺对象
	@RequestMapping("/getOnePFP.action")
	public void getOnePFP(int pf_id,HttpServletResponse response) throws IOException{
		PatrolFlawPojo pfp=patrolService.getOnePFP(pf_id);
		String json=new Gson().toJson(pfp).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(json);
	}
	//ajax异步返回消缺对象 未定义缺陷等级
	@RequestMapping("/getOnePFP2.action")
	public void getOnePFP2(int pf_id,HttpServletResponse response) throws IOException{
		PatrolFlawPojo pfp=patrolService.getOnePFP2(pf_id);
		String json=new Gson().toJson(pfp).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(json);
	}
	@ResponseBody
	@RequestMapping("/uploadPTask.action")
	public String uploadPTask(HttpServletRequest request,PatrolTaskPojo ptp){
		int state=1;
		//查询未保存的塔杆数量
		int a=patrolService.uploadPTask(ptp.getP_id());
		if(a==0) {
			//更改状态
			ptp.setP_state(4);
			patrolService.updatePaskState(ptp);
			ptp.setP_finish_time(new Date());
			patrolService.updatePFinishTime(ptp);
			state=2;
			logService.insertLog("上传回执", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		}
		return state+"";
	}
	//跳转到回执录入
	@RequestMapping("/toUpdateRTask.action")
	public String toUpdateRTask(int p_id,HttpServletRequest request){
		//根据任务id 得到任务详情
		PatrolTaskPojo pTask=patrolService.getOnePatrolTask(p_id);
		//根据任务
		request.setAttribute("pTask", pTask);
		request.setAttribute("flawList", patrolService.getPFlaw());
		return "xunjian/module2/update.jsp";
	}
	
	
	//====================     巡检查询        ============================
	@RequestMapping("/getAllCompletePatrol.action")
	public String getAllCompletePatrol(HttpServletRequest request,FuzzyPartPTaskParams fptp,String nowPage){
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		int count =patrolService.getCompletePatrolCount(fptp);
		PartPage partPage=patrolService.getPartPage(count, page);
		if(count!=0){
			fptp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			fptp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			request.setAttribute("pList", patrolService.getAllCompletePatrol(fptp));
		}
		request.setAttribute("flawList", patrolService.getPFlaw());
		request.setAttribute("page", partPage);
		//参数回显
		request.setAttribute("fptp", fptp);
		return "xunjian/module3/index.jsp";
	}
	//导出excel
	@RequestMapping("/exportPatrolExcel.action")
	public void exportPatrolExcel(HttpServletRequest request,HttpServletResponse response,FuzzyPartPTaskParams fptp,String nowPage) throws ServletException, IOException{
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		int count =patrolService.getCompletePatrolCount(fptp);
		PartPage partPage=patrolService.getPartPage(count, page);
		if(count!=0){
			fptp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			fptp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
		}
		List<PatrolQueryPojo>list=patrolService.getAllCompletePatrol(fptp);
		List<FlawPojo>fList=patrolService.getPFlaw();
		logService.insertLog("巡检查询导出excel", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
		patrolService.export(request, response, list, fList);
	}
	
	//==================      信息统计           ===============================
	@RequestMapping("/getPatrolInformation.action")
	public String getPatrolInformation(HttpServletRequest request,InformationStatisticsParams isp,String nowPage){
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		int count =patrolService.getPatrolInformationCount(isp);
		PartPage partPage=patrolService.getPartPage(count, page);
		if(count!=0){
			isp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			isp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			request.setAttribute("pList", patrolService.getPatrolInformation(isp));
		}
		request.setAttribute("flawList", patrolService.getPFlaw());
		request.setAttribute("page", partPage);
		//参数回显
		request.setAttribute("isp", isp);
		return "xinxi/InspectionEcord.jsp";
	}
	//导出excel
		@RequestMapping("/exportISPExcel.action")
		public void exportISPExcel(HttpServletRequest request,HttpServletResponse response,String nowPage,InformationStatisticsParams isp) throws ServletException, IOException{
			int page=1;
			if(nowPage!=null){
				page=Integer.parseInt(nowPage);
			}
			int count =patrolService.getPatrolInformationCount(isp);
			PartPage partPage=patrolService.getPartPage(count, page);
			isp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			isp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			List<PatrolQueryPojo>list=patrolService.getPatrolInformation(isp);
			List<FlawPojo>fList=patrolService.getPFlaw();
			logService.insertLog("巡检信息统计导出excel", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			patrolService.exportISPExcel(request, response, list, fList);
		}
}
