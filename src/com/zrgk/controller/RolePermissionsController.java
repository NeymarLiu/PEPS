package com.zrgk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.zrgk.pojo.MenuPojo;
import com.zrgk.pojo.RolePermissionsPojo;
import com.zrgk.pojo.RolePojo;
import com.zrgk.service.MenuService;
import com.zrgk.service.RolePermissionsService;
import com.zrgk.service.RoleService;

@Controller
public class RolePermissionsController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RolePermissionsService rolePermissionsService;
	
	public RolePermissionsService getRolePermissionsService() {
		return rolePermissionsService;
	}

	public void setRolePermissionsService(
			RolePermissionsService rolePermissionsService) {
		this.rolePermissionsService = rolePermissionsService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	//跳转到角色赋值权限的页面
	@RequestMapping("/toRolePermissions.action")
	public String toRolePermissions(HttpServletRequest request){
		List<RolePojo> rList=roleService.findAllRoles();
		List<MenuPojo> mList=menuService.findAllMenus();
		request.setAttribute("rList", rList);
		request.setAttribute("mList", mList);
		return "sys/rolePermissions/index.jsp";
	}
	//给角色赋值权限
	@RequestMapping("/toRoleSomePermissions.action")
	public String toRoleSomePermissions(int rid,int[] mid,HttpServletRequest request){
		rolePermissionsService.deleteRoleMenu(rid);
		RolePermissionsPojo rpp=new RolePermissionsPojo();
		rpp.setR_id(rid);
		if(mid != null){
			for (int i = 0; i < mid.length; i++) {
				rpp.setM_id(mid[i]);
				rolePermissionsService.toRoleSomePermissions(rpp);
			}
		}		
		request.setAttribute("isok", "ok");
		return "redirect:toRolePermissions.action";
	}
	//根据角色id 得到相应的权限
	@RequestMapping("/roleToMenu.action")
	public void roleToMenu(int id,HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//查询所有的  回显  查询
		List<Integer> list=rolePermissionsService.getRoleMenuById(id);
		//返回出去  准换为 JSON 
		Gson g = new Gson();
		String gList = g.toJson(list);
		
		out.print(gList);
		
		//关闭资源
		out.flush();
		out.close();
	}
	
}
