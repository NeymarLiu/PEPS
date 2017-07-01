package com.zrgk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.zrgk.pojo.FuzzyPartPTaskParams;
import com.zrgk.pojo.LinePojo;
import com.zrgk.pojo.Linecanshu;
import com.zrgk.pojo.MenuPojo;
import com.zrgk.pojo.PatrolFlawPojo;
import com.zrgk.pojo.PatrolTaskPojo;
import com.zrgk.pojo.PatrolUserPojo;
import com.zrgk.pojo.PolePojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.LineService;
import com.zrgk.service.LogService;
import com.zrgk.util.PartPage;


@Controller
public class LineController {
	@Autowired
	private LineService lineService;
	@Autowired
    private LogService logService;
    
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public LineService getLineService() {
		return lineService;
	}

	public void setLineService(LineService lineService) {
		this.lineService = lineService;
	}
	@RequestMapping(value="/getAllLine.action")
	public String getAllLine(HttpServletRequest request,Linecanshu lc,String nowPage){
		//当前页码	
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		//得到总记录数
		int count =lineService.getAlllineCount(lc);
		PartPage partPage= lineService.getPartPage(count, page);
		if(count!=0){
			lc.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
			lc.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
			request.setAttribute("lpList", lineService.getAllLine(lc));
		}
		request.setAttribute("page", partPage);
		//参数回显
		request.setAttribute("lc",lc);
		return "line/line.jsp";
	}
	//根据线路名称得到关联的线路信息
		//@ResponseBody
		@RequestMapping("/getLIByname.action")
		public void getLIByname(String liname,HttpServletResponse response) throws IOException{
			//得到对应线路 
			List<LinePojo>lpList=lineService.getLIByname(liname);
			Gson gson=new Gson();
			String lines=gson.toJson(lpList).toString();
			response.getWriter().println(lines);
		}
	//跳转到添加页面
	@RequestMapping("/toaddLine.action")
	public String toaddLine(HttpServletRequest request){
				return "line/line_add.jsp";
	}
	//添加线路
		@RequestMapping("/addLine.action")
		public String addLine(LinePojo li,HttpServletRequest request){
		     UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		     logService.insertLog("添加线路", up.getU_id());
			//在数据库中查询最大的liid
			int maxLi_id=lineService.getmaxLi_id();  
			li.setLi_id(maxLi_id);
			int a=lineService.addLine(li);
		        if(a>0){
					return "redirect:toaddLine.action";
				}else{
					return "addLine.action";
				}
			
		}
		//删除菜单
		@RequestMapping("/deleteLine.action")
		public String deleteLine(HttpServletRequest request){
			UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		    logService.insertLog("删除线路", up.getU_id());
			String id=request.getParameter("liid");
			int a=-1;
			if(id != null){
				a=Integer.parseInt(id);
			}
			int b=lineService.deleteLine(a);
			return "getAllLine.action";
		}
		//跳转到修改页面
		@RequestMapping("/toUpdateLine.action")
		public String toUpdateLine(String liid,HttpServletRequest request){
			String id=liid;
			int a=-1;
			if(id != null){
				a=Integer.parseInt(id);
				LinePojo li=lineService.getLineById(a);
				request.setAttribute("line", li);
			}
			return "line/line_edit.jsp";
		}
		//修改线路
		@RequestMapping("/updateLine.action")
		public String updateLine(String liid,LinePojo lp,HttpServletRequest request){
			 UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		     logService.insertLog("修改线路", up.getU_id());
			String id=liid;
			int a=lineService.updateLine(lp);
			if(a>0){
				return "redirect:getAllLine.action";
			}else{
				return "toUpdateLine.action?lid="+id;
			}
			
		}
		//状态值修改
	   @RequestMapping("/lineState.action")
		public String  lineState(LinePojo lp){
			int b=lineService.lineState(lp);
			return "getAllLine.action";
	   }
	   @ResponseBody
	   @RequestMapping(value="/selectlicode.action")
	   public String selectlicode(LinePojo lp,HttpServletRequest request,HttpServletResponse response) throws IOException{
			
			int a  =  lineService.selectlicode(lp);
			return a+"";
		}
	 /*  @ResponseBody
	   @RequestMapping(value="/selectlicode2.action")
	   public String selectlicode2(LinePojo lp,HttpServletRequest request,HttpServletResponse response) throws IOException{
			
			int a  =  lineService.selectlicode(lp);
			return a+"";
		}*/
	/*   @RequestMapping(value="/selectlicode2.action")
	   public String  selectlicode2(LinePojo lp){
			
	   }
		*/
	/*@RequestMapping("/getAllLine.action")
	public String getAllLine(HttpServletRequest request,Linecanshu lu,String nowPage){
		//当前页码	
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		//得到总记录数
		int count =lineService.getCount(lu);
		PartPage partPage=lineService.getPartPage(count, page);
		lu.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
		lu.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
		request.setAttribute("lpList", lineService.getAllLine(lu));
		request.setAttribute("page", partPage);
		//参数回显
		request.setAttribute("lu", lu);
		return "line/line.jsp";
	}*/
	//
	   
	   //更改线路状态   0  启用  1  停用   2   删除
	   //   参数  线路id   状态值    liid  li_sate 
	   
	   //   linepojo  
	   //   update  line   set  li_state=#{li_state} where li_id=#{li_id}
}
