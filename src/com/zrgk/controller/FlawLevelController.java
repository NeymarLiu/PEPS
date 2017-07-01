package com.zrgk.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zrgk.pojo.FlawSureParams;
import com.zrgk.pojo.PatrolFlawPojo;
import com.zrgk.pojo.PatrolTaskPojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.FlawLevelService;
import com.zrgk.service.LogService;
import com.zrgk.service.PatrolService;
import com.zrgk.util.PartPage;

@Controller
public class FlawLevelController {
	@Autowired
	private FlawLevelService flawLevelService;
	@Autowired
	private PatrolService patrolService;
	@Autowired
	private LogService logService;
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public void setPatrolService(PatrolService patrolService) {
		this.patrolService = patrolService;
	}
	public PatrolService getPatrolService() {
		return patrolService;
	}
	public FlawLevelService getFlawLevelService() {
		return flawLevelService;
	}

	public void setFlawLevelService(FlawLevelService flawLevelService) {
		this.flawLevelService = flawLevelService;
	}
	@RequestMapping("/getAllSureFlawPojo.action")
	public String getAllPatrolFlawPojo(HttpServletRequest request,FlawSureParams fsp,String nowPage){
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		//得到总记录数
		int count =flawLevelService.getAllPatrolFlawPojoCount(fsp);
		PartPage partPage=flawLevelService.getPartPage(count, page);
		if(count!=0){
			fsp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			fsp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			request.setAttribute("ptaskList", flawLevelService.getAllPatrolFlawPojo(fsp));
		}
		request.setAttribute("page", partPage);
		//参数回显
		request.setAttribute("fsp", fsp);
		request.setAttribute("fList", patrolService.getPFlaw());
		request.setAttribute("mark", request.getAttribute("mark"));
		return "flaw/level/index.jsp";
	}
	@RequestMapping("/sureFlaw.action")
	public String sureFlaw(String arr[],HttpServletRequest request){
		PatrolFlawPojo pfp=new PatrolFlawPojo();
		for (int i = 0; i < arr.length; i++) {
			//缺陷任务id
			pfp.setPf_id(Integer.parseInt(arr[i].split("_")[1]));
			//缺陷级别
			pfp.setPf_sure_grade(Integer.parseInt(arr[i].split("_")[2]));
			flawLevelService.sureFlaw(pfp);
		}
		//巡检任务id
		int p_id=Integer.parseInt(arr[0].split("_")[0]);
		int count=flawLevelService.getUnSureCount(p_id);
		//更改状态
		if(count==0){
			PatrolTaskPojo ptp=new PatrolTaskPojo();
			ptp.setP_state(5);
			ptp.setP_id(p_id);
			patrolService.updatePaskState(ptp);
			
		}
		UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		logService.insertLog("确认缺陷级别", up.getU_id());
		request.setAttribute("mark", 1);
		return "getAllSureFlawPojo.action";
	}
	
}
