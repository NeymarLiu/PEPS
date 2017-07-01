package com.zrgk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.FuzzyFlawParams;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.FlawService;
import com.zrgk.service.LogService;
import com.zrgk.util.PartPage;

@Controller
public class FlawController {
	@Autowired
	private FlawService flawService;
	@Autowired
	private LogService logService;
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public FlawService getFlawService() {
		return flawService;
	}

	public void setFlawService(FlawService flawService) {
		this.flawService = flawService;
	}
	//得到缺陷信息
	@RequestMapping("/getAllFlaw.action")
	public String getAllFlaw(HttpServletRequest request,HttpServletResponse response,FuzzyFlawParams ffp,String nowPage){
		response.setCharacterEncoding("utf-8");
		//当前页码	
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		//得到总记录数
		int count =flawService.getAllFlawPojoCount(ffp);
		PartPage partPage=flawService.getPartPage(count, page);
		if(count!=0){
			ffp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			ffp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			request.setAttribute("fpList", flawService.getAllFlawPojo(ffp));
		}
		request.setAttribute("page", partPage);
		//参数回显
		request.setAttribute("state",request.getAttribute("state"));
		request.setAttribute("ffp", ffp);
		return "flaw/type/index.jsp";
		
	}
	@RequestMapping("/addFlawPojo.action")
	public String addFlaw(FlawPojo fp,HttpServletRequest request){
		int flag=flawService.addFlawPojo(fp);
		UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		logService.insertLog("添加缺陷类型", up.getU_id());
		request.setAttribute("flag", flag);
		return "flaw/type/add.jsp";
	}
	@ResponseBody
	@RequestMapping("/checkFName.action")
	public void checkFName(FlawPojo fw,HttpServletResponse response) throws IOException{
		response.getWriter().println(flawService.checkFName(fw));
	}
	@RequestMapping("/toUpdateFlawPojo.action")
	public String toUpdateFlawPojo(int f_id,HttpServletRequest request){
		FlawPojo fp=flawService.toUpdateFlawPojo(f_id);
		request.setAttribute("fp", fp);
		request.setAttribute("flag", request.getAttribute("flag"));
		return "flaw/type/update.jsp";
	}
	@RequestMapping("/UpdateFlawPojo.action")
	public String UpdateFlawPojo(FlawPojo fp,HttpServletRequest request){
		
		int flag=flawService.UpdateFlawPojo(fp);
		UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		logService.insertLog("修改缺陷类型", up.getU_id());
		request.setAttribute("flag", flag);
		return "toUpdateFlawPojo.action";
	}
	@RequestMapping("/UpdateFlawPojo2.action")
	public String UpdateFlawPojo2(FlawPojo fp,HttpServletRequest request){
		UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		logService.insertLog("删除缺陷类型", up.getU_id());
		request.setAttribute("state", flawService.UpdateFlawPojo2(fp));
		return "getAllFlaw.action";
	}
	
}

