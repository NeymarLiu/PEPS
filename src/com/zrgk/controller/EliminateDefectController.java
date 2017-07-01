package com.zrgk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zrgk.pojo.EdTaskPatrolFlowPojo;
import com.zrgk.pojo.EdTaskPojo;
import com.zrgk.pojo.EliminateDefectPojo;
import com.zrgk.pojo.EliminateDefectUserPojo;
import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.MoHuTask;
import com.zrgk.pojo.PatrolQueryPojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.EliminateDefectService;
import com.zrgk.service.LogService;
import com.zrgk.util.PartPage;

@Controller
public class EliminateDefectController {

	/**
	 * @author wujin
	 */
	@Autowired
	private EliminateDefectService eliminateDefectService;
	@Autowired
	private LogService logService;
	public EliminateDefectService getEliminateDefectService() {
		return eliminateDefectService;
	}
	public void setEliminateDefectService(
			EliminateDefectService eliminateDefectService) {
		this.eliminateDefectService = eliminateDefectService;
	}
	
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
		/*//查询所有任务
		@RequestMapping(value="/selectAllTask.action")
		public String getAllEliminateDefect(HttpServletRequest request){
			List<EliminateDefectPojo> edpList = eliminateDefectService.getAllEliminateDefect();
			request.setAttribute("edpList", edpList);
			return "xiaoque/module1/index.jsp";
		}*/
	//模糊查询所有任务
		@RequestMapping(value="/moHuEdTask.action")
		public String getAllEliminateDefect2(MoHuTask mht,HttpServletRequest request,String nowPage){
			//当前页码	
			int page=1;
			if(nowPage!=null){
				page=Integer.parseInt(nowPage);
			}
			//得到总记录数
			mht.setId(((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			int count =eliminateDefectService.getAllTaskCount(mht);
			PartPage partPage=eliminateDefectService.getPartPage(count, page);
			if(count!=0){
				mht.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
				mht.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
				List<EliminateDefectPojo> edpList = eliminateDefectService.getSomeEliminateDefect(mht);
				request.setAttribute("edpList",edpList );
			}
			request.setAttribute("mht", mht);
			request.setAttribute("page", partPage);
			request.setAttribute("mht", mht);
			return "xiaoque/module1/index.jsp";
		}
		@RequestMapping(value="/goToEdTask.action")
		public String goToEdTask(HttpServletRequest request){
			//得到最大任务的id
			String s=eliminateDefectService.getMaxTaskId();
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
			request.setAttribute("rwid", "XQ"+str+s);
			//任务负责人信息
			request.setAttribute("issuedList", eliminateDefectService.getAllIssued());
			//消缺员信息
			request.setAttribute("edplList", eliminateDefectService.getEliminateDefectPeople());
			//得到所有需要消缺的缺陷
			List<EdTaskPojo> pqpList = eliminateDefectService.selectAllFlaw();
			request.setAttribute("pqpList",pqpList);
			
			return "xiaoque/module1/add.jsp";
		}
		//向数据库添加消缺任务，及执行任务的消缺员
		@RequestMapping(value="/insertEdTask.action")
		public String insertEdTask(int u_realid,EliminateDefectPojo edp,HttpServletRequest request,int[] u_id,int[] check){
			if (u_id==null) {
				edp.setE_task_state(1);
			}else {
				edp.setE_task_state(2);
			}
			//根据id找到人名
			edp.setE_task_principal(eliminateDefectService.getRealnameById(u_realid));
			//System.out.println(u_id);
			//添加消缺任务
			edp.setE_issued_id(((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			eliminateDefectService.addEdTask(edp);
			//循环添加消缺员
			EliminateDefectUserPojo edup = new EliminateDefectUserPojo();
			//根据任务编号获得任务的id
			int e_id = eliminateDefectService.getIdByTask(edp);
			//中间表插入任务id关联消缺的消缺员
			edup.setE_id(e_id);
			if (u_id != null) {
				//改变任务状态为已分配
				eliminateDefectService.updateEdState(e_id);
				for (int i = 0; i < u_id.length; i++) {
					edup.setU_id(u_id[i]);
					eliminateDefectService.addEdUser(edup);
				}
			}
			//中间表循环加入缺陷
			EdTaskPatrolFlowPojo epfp = new EdTaskPatrolFlowPojo();
			epfp.setETPF_E_ID(e_id);
			for (int j = 0; j < check.length; j++) {
				epfp.setETPF_PF_ID(check[j]);
				eliminateDefectService.addEdTaskPatrol(epfp);
				eliminateDefectService.updatePfState(epfp);
			}
			logService.insertLog("下发消缺任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			request.setAttribute("ceshi", 1);
			return "goToEdTask.action";
		}
		//取消任务
		@RequestMapping(value="/deleteTask.action")
		public String deleteTask(int e_id,HttpServletRequest request){
			//改变任务的状态
			eliminateDefectService.deleteTask(e_id);
			eliminateDefectService.freeTask(e_id);
			logService.insertLog("取消巡检任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			return "moHuEdTask.action";
		}
		@RequestMapping(value="/shareTask.action")
		public String shareTask(int id,HttpServletRequest request){
			//得到所有的消缺人员
			List<UserPojo> upList =eliminateDefectService.getEliminateDefectPeople();
			request.setAttribute("e_id",id);
			request.setAttribute("upList", upList);
			return "xiaoque/module1/share.jsp";
		}
		//添加消缺人员
		@RequestMapping(value="/addEdUser.action")
		public String addEdUser(int[] check,int e_id,EliminateDefectUserPojo edup,HttpServletRequest request){
			//得到所有的消缺人员循环插入
			//中间表插入任务id关联消缺的缺陷
			edup.setE_id(e_id);
			//改变任务状态为已分配
			for (int j = 0; j < check.length; j++) {
				edup.setU_id(check[j]);
				eliminateDefectService.addEdUser(edup);
			}
			eliminateDefectService.updateEdState(e_id);
			logService.insertLog("分配任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			request.setAttribute("ceshi", 1);
			return "moHuEdTask.action";
		}
		//修改任务
		@RequestMapping(value="/toUpdateEdTask.action")
		public String updateEdTak(int id,EliminateDefectUserPojo edup,HttpServletRequest request){
			
			EliminateDefectPojo edp= eliminateDefectService.getAllValue(id);//得到该任务下的数据详情
			List<EdTaskPojo> etpList = eliminateDefectService.selectTaskDetail(id);
			//任务负责人信息
			request.setAttribute("issuedList", eliminateDefectService.getAllIssued());
			request.setAttribute("upList", eliminateDefectService.getEliminateDefectPeople());
			request.setAttribute("edp", edp);
			request.setAttribute("etpList", etpList);
			return "xiaoque/module1/update.jsp";
		}
		//修改数据
		@RequestMapping(value="/updateEdTaskTwo.action")
		public String updateEdTaskTwo(int e_id,int[] u_id,EliminateDefectUserPojo edup,EliminateDefectPojo edp,HttpServletRequest request){
			//循环插入更改任务
			eliminateDefectService.updateEdTask(edp);
			//循环插入任务和消缺员
			edup.setE_id(e_id);
			if (u_id != null) {
				//改变任务的状态为已分配
				eliminateDefectService.updateEdState(e_id);
				for (int i = 0; i < u_id.length; i++) {
					edup.setU_id(u_id[i]);
					eliminateDefectService.addEdUser(edup);
				}
			}
			logService.insertLog("修改消缺任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			return "moHuEdTask.action";
		}
		//查询
		@RequestMapping(value="/toLookEdTask.action")
		public String lookEdTask(int id,EliminateDefectUserPojo edup,HttpServletRequest request){
			
			EliminateDefectPojo edp= eliminateDefectService.getAllValue(id);//得到该任务下的数据详情
			List<EdTaskPojo> etpList = eliminateDefectService.selectTaskDetail(id);
			//任务负责人信息
			request.setAttribute("issuedList", eliminateDefectService.getAllIssued());
			request.setAttribute("upList", eliminateDefectService.lookOneTaskUser(id));
			request.setAttribute("edp", edp);
			request.setAttribute("etpList", etpList);
			return "xiaoque/module1/look.jsp";
		}
		//消缺员登录模糊查询所有
		@RequestMapping(value="/moHuEdTaskUser.action")
		public String moHuEdTaskUser(MoHuTask mht,HttpServletRequest request,String nowPage){
			//得到当前登陆者
			mht.setUser((UserPojo)request.getSession().getAttribute("loginUser"));
			//分页
			int page=1;
			if(nowPage!=null){
				page=Integer.parseInt(nowPage);
			}
			//得到总记录数
			int count =eliminateDefectService.getAllTaskCount2(mht);
			//System.out.println(count);
			PartPage partPage=eliminateDefectService.getPartPage(count, page);
			if(count!=0){
				mht.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
				mht.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
				List<EliminateDefectPojo> edpList = eliminateDefectService.getSomeEliminateDefectTwo(mht);
				//System.out.println(edpList.get(1).getE_id());
				request.setAttribute("edpList",edpList );
			}
			request.setAttribute("mht", mht);
			request.setAttribute("page", partPage);
			request.setAttribute("mht", mht);
			return "xiaoque/module2/index.jsp";
		}
		//回执查看
		@RequestMapping(value="edReceiptLook.action")
		public String edReceiptLook(int id,HttpServletRequest request){
			//得到任务的id
			EliminateDefectPojo edp= eliminateDefectService.getAllValue(id);//得到该任务下的数据详情
			List<EdTaskPojo> etpList = eliminateDefectService.selectTaskDetail(id);
			//任务负责人信息
			request.setAttribute("issuedList", eliminateDefectService.getAllIssued());
			request.setAttribute("upList", eliminateDefectService.lookOneTaskUser(id));
			request.setAttribute("edp", edp);
			request.setAttribute("etpList", etpList);
			return "xiaoque/module2/look.jsp";
		}
		//回执录入
		@RequestMapping(value="edToReceiptEnter.action")
		public String edToReceiptEnter(int id,HttpServletRequest request){
			//得到任务的id
			EliminateDefectPojo edp= eliminateDefectService.getAllValue(id);//得到该任务下的数据详情
			List<EdTaskPojo> etpList = eliminateDefectService.selectTaskDetail(id);
			//任务负责人信息
			request.setAttribute("issuedList", eliminateDefectService.getAllIssued());
			request.setAttribute("upList", eliminateDefectService.lookOneTaskUser(id));
			request.setAttribute("edp", edp);
			request.setAttribute("etpList", etpList);
			return "xiaoque/module2/enter.jsp";
		}
		//执行
		@RequestMapping(value="edReceiptDo.action")
		public String edReceiptDo(int id,HttpServletRequest request){
			//根据任务的id改变他的状态
			eliminateDefectService.updateEdStateTwo(id);
			logService.insertLog("执行消缺任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			return "moHuEdTaskUser.action";
		}
		//保存
		@RequestMapping(value="toUpdateReceiptTwo.action")
		public String toUpdateReceiptTwo(int id,HttpServletRequest request){
			//得到任务的id
			EliminateDefectPojo edp= eliminateDefectService.getAllValue(id);//得到该任务下的数据详情
			List<EdTaskPojo> etpList = eliminateDefectService.selectTaskDetail(id);
			//任务负责人信息
			request.setAttribute("issuedList", eliminateDefectService.getAllIssued());
			request.setAttribute("upList", eliminateDefectService.lookOneTaskUser(id));
			request.setAttribute("edp", edp);
			request.setAttribute("etpList", etpList);
			return "xiaoque/module2/enter.jsp";
		}
		//保存录入
		@RequestMapping(value="updateReceiptTwo.action")
		public String updateReceiptTwo(EliminateDefectPojo edp,HttpServletRequest request) throws IOException{
			//得到任务的id
			//添加任务完成描述addReceiptEnter
			eliminateDefectService.addUpdateReceipt(edp);
			logService.insertLog("录入消缺任务保存", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			request.setAttribute("ceshi", 1);
			return "toUpdateReceiptTwo.action?id="+edp.getE_id();
		}
		//回执录入提交
		@RequestMapping(value="edReceiptEnter.action")
		public String edReceiptEnter(EliminateDefectPojo edp,HttpServletRequest request) {
			//变为已完成
			eliminateDefectService.updateEdStateThree(edp);
			logService.insertLog("完成消缺任务", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			return "edToReceiptEnter.action?id="+edp.getE_id();
		}
		
		//修改
		@RequestMapping(value="toUpdateReceipt.action")
		public String toUpdateReceipt(int id,HttpServletRequest request){
			//得到任务的id
			EliminateDefectPojo edp= eliminateDefectService.getAllValue(id);//得到该任务下的数据详情
			List<EdTaskPojo> etpList = eliminateDefectService.selectTaskDetail(id);
			//任务负责人信息
			request.setAttribute("issuedList", eliminateDefectService.getAllIssued());
			request.setAttribute("upList", eliminateDefectService.lookOneTaskUser(id));
			request.setAttribute("edp", edp);
			request.setAttribute("etpList", etpList);
			return "xiaoque/module2/update.jsp";
		}
		//修改录入
		@RequestMapping(value="updateReceipt.action")
		public String updateReceipt(EliminateDefectPojo edp,HttpServletRequest request) throws IOException{
			//得到任务的id
			//添加任务完成描述addReceiptEnter
			eliminateDefectService.addUpdateReceipt(edp);
			logService.insertLog("录入消缺任务修改", ((UserPojo)(request.getSession().getAttribute("loginUser"))).getU_id());
			request.setAttribute("ceshi", 1);
			return "toUpdateReceipt.action?id="+edp.getE_id();
		}
		//查询任务所有的数据
		@RequestMapping(value="selectAllEdTaskDetail.action")
		public String selectAllEdTaskDetail(String nowPage,MoHuTask mht,HttpServletRequest request){
			//当前页码	
			int page=1;
			if(nowPage!=null){
				page=Integer.parseInt(nowPage);
			}
			//得到总记录数
			int count =eliminateDefectService.getAllTaskCount3(mht);
			//得到所有的缺陷
			List<FlawPojo> fpList = eliminateDefectService.selectAllFlaw2();
			PartPage partPage=eliminateDefectService.getPartPage(count, page);
			if(count!=0){
				mht.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
				mht.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
				//任务详情
				List<EdTaskPojo> etpList = eliminateDefectService.getSomeEliminateDefect3(mht);
				request.setAttribute("etpList",etpList );
			}
			request.setAttribute("fpList", fpList);
			request.setAttribute("page", partPage);
			request.setAttribute("mht", mht);
			
			return "xiaoque/module3/index.jsp";
		}
			//导出excel
		@RequestMapping("/exportExcel.action")
		public void exportISPExcel(HttpServletResponse response,String nowPage,MoHuTask mht,HttpServletRequest request) throws ServletException, IOException{
			//当前页码	
			int page=1;
			if(nowPage!=null){
				page=Integer.parseInt(nowPage);
			}
			//得到总记录数
			int count =eliminateDefectService.getAllTaskCount3(mht);
			//得到所有的缺陷
			List<FlawPojo> fpList = eliminateDefectService.selectAllFlaw2();
			PartPage partPage=eliminateDefectService.getPartPage(count, page);
			mht.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			mht.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			//任务详情
			List<EdTaskPojo> list = eliminateDefectService.getSomeEliminateDefect3(mht);
			eliminateDefectService.export(request, response, list);
		}
		
	//=====================	信息统计================================
		
		@RequestMapping(value="selectAllEdTaskDetailTwo.action")
		public String selectAllEdTaskDetailTwo(String nowPage,MoHuTask mht,HttpServletRequest request){
			//当前页码	
			int page=1;
			if(nowPage!=null){
				page=Integer.parseInt(nowPage);
			}
			//得到总记录数
			int count =eliminateDefectService.getAllTaskCount3(mht);
			//得到所有的缺陷
			List<FlawPojo> fpList = eliminateDefectService.selectAllFlaw2();
			PartPage partPage=eliminateDefectService.getPartPage(count, page);
			if(count!=0){
				mht.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
				mht.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
				//任务详情
				List<EdTaskPojo> etpList = eliminateDefectService.getSomeEliminateDefect3(mht);
				request.setAttribute("etpList",etpList );
			}
			request.setAttribute("fpList", fpList);
			request.setAttribute("page", partPage);
			request.setAttribute("mht", mht);
			
			return "xinxi/EliminatingEcord.jsp";
		}	
		
		

		//导出excel
	@RequestMapping("/exportISPExcelTwo.action")
	public void exportISPExcelTwo(HttpServletResponse response,String nowPage,MoHuTask mht,HttpServletRequest request) throws ServletException, IOException{
		//当前页码	
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		//得到总记录数
		int count =eliminateDefectService.getAllTaskCount3(mht);
		//得到所有的缺陷
		List<FlawPojo> fpList = eliminateDefectService.selectAllFlaw2();
		PartPage partPage=eliminateDefectService.getPartPage(count, page);
		mht.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
		mht.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
		//任务详情
		List<EdTaskPojo> list = eliminateDefectService.getSomeEliminateDefect3(mht);
		eliminateDefectService.export(request, response, list);
	}
		
		
}