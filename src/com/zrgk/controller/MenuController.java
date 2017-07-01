package com.zrgk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.zrgk.pojo.MenuPageParams;
import com.zrgk.pojo.MenuPojo;
import com.zrgk.pojo.RolePojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.LogService;
import com.zrgk.service.MenuService;
import com.zrgk.util.PartPage;
/**
 * 
 * @author longwenyu
 * @version 
 */
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private LogService logService;
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	
	@RequestMapping("/getUserMenus.action")
	public String getUserMenus(HttpServletRequest request,HttpServletResponse response){
		UserPojo up=(UserPojo)request.getSession().getAttribute("loginUser");
		List<MenuPojo> menuList=menuService.getUserMenus(up.getRolePojo().getR_id());
		request.getSession().setAttribute("menuList", menuList);
		return "/index.jsp";
	}
	
	//得到菜单信息
	@RequestMapping("/getAllMenus.action")
	public String getAllMenus(String nowPage,MenuPageParams mpp,HttpServletRequest request,HttpServletResponse response){
		String type=request.getParameter("type");
		if(mpp.getM_name() != null){
			String n=mpp.getM_name();
			mpp.setM_name(n.replaceAll(" ", ""));
		}
		if("add".equals(type) || "update".equals(type)){
			mpp.setM_name(null);
		}
		int page=1;
		if(nowPage != null){
			page=Integer.parseInt(nowPage);
		}
		int count =menuService.getCount(mpp);
		PartPage partPage=menuService.getPartPage(count, page);
		mpp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
		mpp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
		List<MenuPojo> menuList=menuService.getAllMenus(mpp);
		request.setAttribute("page", partPage);
		request.setAttribute("mList", menuList);
		//显示回显参数
		request.setAttribute("mpp", mpp);
		return "sys/menu/index.jsp";
	}
	//跳转到添加页面
	@RequestMapping("/toAddMenu.action")
	public String toAddMenu( HttpServletRequest request){
		//得到所有可用的父级菜单
		List<MenuPojo> list=menuService.findAllFatherMenus();
		request.setAttribute("mfather", list);
		return "sys/menu/ok.jsp";
	}
	//添加菜单
	@RequestMapping("/addMenu.action")
	public String addMenu(MenuPojo mp,HttpServletRequest request){
		System.out.println(""+mp.getM_father()+"--"+mp.getM_state());
		int a=menuService.addMenu(mp);
		UserPojo user=(UserPojo)request.getSession().getAttribute("loginUser");
		int userid=user.getU_id();
		if(a>0){
			logService.insertLog("添加菜单", userid);
			return "redirect:getAllMenus.action?type=add";
		}else{
			return "addMenu.action";
		}
	}
	//跳转到修改页面
	@RequestMapping("/toUpdateMenu.action")
	public String toUpdateMenu( HttpServletRequest request){
		String id=request.getParameter("mid");
		int a=-1;
		if(id != null){
			a=Integer.parseInt(id);
		}
		List<MenuPojo> list=menuService.findAllFatherMenus();
		
		MenuPojo m=menuService.getMenuById(a);
		request.setAttribute("mfather", list);
		request.setAttribute("menu", m);
		return "sys/menu/okup.jsp";
	}
	//修改菜单
	@RequestMapping("/updateMenu.action")
	public String updateMenu(MenuPojo mp,HttpServletRequest request){
		int a=menuService.updateMenu(mp);
		menuService.updateMenu2(mp);
		UserPojo user=(UserPojo)request.getSession().getAttribute("loginUser");
		int userid=user.getU_id();
		if(a>0){
			logService.insertLog("修改菜单", userid);
			return "redirect:getAllMenus.action?type=update";
		}else{
			return "toUpdateMenu.action";
		}
		
	}
	
	//删除菜单
	@RequestMapping("/deleteMenu.action")
	public String deleteMenu(HttpServletRequest request){
		String id=request.getParameter("mid");
		int a=-1;
		if(id != null){
			a=Integer.parseInt(id);
		}
		UserPojo user=(UserPojo)request.getSession().getAttribute("loginUser");
		int userid=user.getU_id();
		logService.insertLog("删除菜单", userid);
		int b=menuService.deleteMenu(a);
		int b2=menuService.deleteMenu2(a);
		return "redirect:getAllMenus.action";
	}
	
	//菜单的唯一性验证
	@RequestMapping("/menuNameOnly.action")
	public void menuNameOnly(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String mymname=request.getParameter("mymname");
		mymname=mymname.replaceAll(" ", "");
		//查询所有的  回显  查询
		List<MenuPojo> roleList=menuService.findAllMenus();
		int isok=1;
		for(int i = 0; i < roleList.size(); i++){
			if(roleList.get(i).getM_name().equals(mymname)){
				isok=0;
			}			
		}
		//返回出去  准换为 JSON 
		Gson g = new Gson();
		String gList = g.toJson(isok);
		out.print(gList);
		//关闭资源
		out.flush();
		out.close();
	}
	//菜单的唯一性验证
	@RequestMapping("/menuNameOnly2.action")
	public void menuNameOnly2(String mymname,int mymid,HttpServletRequest request,HttpServletResponse response) throws IOException{
		//输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		mymname=mymname.replaceAll(" ", "");
		//查询所有的  回显  查询
		List<MenuPojo> roleList=menuService.findAllMenus();
		int isok=1;
		if(mymid != 0){
			for (int i = 0; i < roleList.size(); i++) {
				if(roleList.get(i).getM_id() ==mymid){
					roleList.remove(i);				
				}			
			}			
		}
		for(int i = 0; i < roleList.size(); i++){
			if(roleList.get(i).getM_name().equals(mymname)){
				isok=0;
			}			
		}
		//返回出去  准换为 JSON 
		Gson g = new Gson();
		String gList = g.toJson(isok);
		out.print(gList);
		//关闭资源
		out.flush();
		out.close();
	}
}
