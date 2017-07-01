package com.zrgk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zrgk.pojo.LogPageParams;
import com.zrgk.pojo.LogPojo;
import com.zrgk.service.LogService;
import com.zrgk.util.PartPage;


/**
 * 日志
 * @author 龙汶宇
 *
 */
@Controller
public class LogController {
	@Autowired
	private LogService logService;
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	//将日志插入到表中
	@RequestMapping("/getAllLogById.action")
	public String getAllLogById(String nowPage,LogPageParams lpp,HttpServletRequest request){
		int page=1;
		if(nowPage != null){
			page=Integer.parseInt(nowPage);
		}
		int count =logService.getCount(lpp);
		PartPage partPage=logService.getPartPage(count, page);
		lpp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
		lpp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
		List<LogPojo> logList=logService.getAllLogById(lpp);
		request.setAttribute("page", partPage);
		request.setAttribute("logList", logList);
		request.setAttribute("lpp", lpp);
		return "sys/userManager/log.jsp";
	}
}
