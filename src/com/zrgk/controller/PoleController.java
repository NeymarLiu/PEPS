package com.zrgk.controller;



import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zrgk.pojo.FuzzyPoleParams;
import com.zrgk.pojo.LinePojo;
import com.zrgk.pojo.PolePojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.LineService;
import com.zrgk.service.LogService;
import com.zrgk.service.PatrolService;
import com.zrgk.service.PoleService;
import com.zrgk.util.PartPage;
@Controller
public class PoleController {
	@Autowired
	private PoleService poleService;
	@Autowired
	private LineService lineService;
	@Autowired
	private LogService logService;
	@Autowired
	private PatrolService patrolService;
	public void setPatrolService(PatrolService patrolService) {
		this.patrolService = patrolService;
	}
	public LineService getLineService() {
		return lineService;
	}
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	
	public void setLineService(LineService lineService) {
		this.lineService = lineService;
	}
	public PoleService getPoleService() {
		return poleService;
	}

	public void setPoleService(PoleService poleService) {
		this.poleService = poleService;
	}
	//得到所有塔杆信息
	@RequestMapping("/getAllPole.action")
	public String getAllPole(HttpServletRequest request,HttpServletResponse response,FuzzyPoleParams fpp,String nowPage){
		response.setCharacterEncoding("utf-8");
		//当前页码	
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		//得到总记录数
		int count =poleService.getAllPolePojoCount(fpp);
		PartPage partPage=poleService.getPartPage(count, page);
		if(count!=0){
			fpp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			fpp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			request.setAttribute("ppList", poleService.getAllPolePojo(fpp));
		}
		request.setAttribute("page", partPage);
		//参数回显
		request.setAttribute("fpp", fpp);
		request.setAttribute("state",request.getAttribute("state"));
		return "pole/pole.jsp";	
	}
	/*
	//修改塔杆
	@RequestMapping("/editPole.action")
	public String editPole(HttpServletRequest request){
				
		return "pole/edit.jsp";
	}*/
	@RequestMapping("/updatePole.action")
	//更改塔杆状态
	public String updatePole(PolePojo pp,HttpServletRequest request){
		UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		logService.insertLog("更改塔杆状态", up.getU_id());
		request.setAttribute("state",poleService.updatePole(pp));
		return "getAllPole.action";
	}
	@RequestMapping("/toUpdatePoleInfo.action")
	public String toUpdatePole(int pole_id,HttpServletRequest request){
		request.setAttribute("pole",poleService.getPolePojo(pole_id));
		request.setAttribute("flag", request.getAttribute("flag"));
		return "pole/pole_edit.jsp";
	}
	@RequestMapping("/UpdatePoleInfo.action")
	public String UpdatePoleInfo(PolePojo pp,HttpServletRequest request){
		UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		logService.insertLog("更改塔杆信息", up.getU_id());
		request.setAttribute("flag",poleService.updatePoleInfo(pp));
		return "toUpdatePoleInfo.action?pole_id="+pp.getPole_id();
	}
	@RequestMapping("/toAddPole.action")
	public String toAddPole(HttpServletRequest request){
		request.setAttribute("lineList", patrolService.getAllLine());
		return "pole/pole_add.jsp";
	}
	@RequestMapping("/addPole.action")
	public String addPole(PolePojo pp,HttpServletRequest request,String licode){
		pp.setPole_time(new Date());
		pp.setPole_code(licode+"_"+pp.getPole_code());
		pp.setLi_id(Integer.parseInt(poleService.getLineId(pp.getPole_code().split("_")[0])));
		UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		logService.insertLog("添加塔杆", up.getU_id());
		request.setAttribute("flag", poleService.addPole(pp));
		return "toAddPole.action";
	}
	@RequestMapping("/checkPCode.action")
	public void checkPCode(PolePojo pp,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		//得到线路id
		String str="";
		String li_id=poleService.getLineId(pp.getPole_code().split("_")[0]);
		if(li_id==null){
			str="线路不存在!";
		}else {
			LinePojo lp=lineService.getLineById(Integer.parseInt(li_id));
			int c1=pp.getPole_code().compareTo(lp.getLi_beginpole());
			int c2=lp.getLi_endpole().compareTo(pp.getPole_code());
			//当塔杆在线路的起始终止塔杆范围内时
			if(c1>-1&&c2>-1){
				pp.setLi_id(lp.getLi_id());
				PolePojo p=poleService.getPolePojoByPP(pp);
				if(p==null){
					str="1";
				}else{
					str="塔杆编号已存在!";
				}
			}else{
				str="塔杆编号超出对应的线路起始终止塔杆范围!";
			}
		}
		response.getWriter().println(str);
	}
}

