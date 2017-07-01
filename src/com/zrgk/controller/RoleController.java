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
import com.zrgk.pojo.RolePageParams;
import com.zrgk.pojo.RolePojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.LogService;
import com.zrgk.service.RolePermissionsService;
import com.zrgk.service.RoleService;
import com.zrgk.util.PartPage;
/**
 * 
 * @author longwenyu
 * @version 
 */
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private LogService logService;
	@Autowired
	private RolePermissionsService rolePermissionsService;
	
	public RolePermissionsService getRolePermissionsService() {
		return rolePermissionsService;
	}

	public void setRolePermissionsService(
			RolePermissionsService rolePermissionsService) {
		this.rolePermissionsService = rolePermissionsService;
	}
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	//得到角色信息
	@RequestMapping("/getAllRoles.action")
	public String getAllRoles(String nowPage,RolePageParams rpp,HttpServletRequest request,HttpServletResponse response){
		int page=1;
		if(rpp.getR_name() != null){
			String n=rpp.getR_name();
			rpp.setR_name(n.replaceAll(" ", ""));
		}
		if(nowPage != null){
			page=Integer.parseInt(nowPage);
		}
		int count =roleService.getCount(rpp);
		PartPage partPage=roleService.getPartPage(count, page);
		rpp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
		rpp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
		List<RolePojo> roleList=roleService.getAllRoles(rpp);
		request.setAttribute("page", partPage);
		request.setAttribute("action", "getAllRoles");
		request.setAttribute("rList", roleList);
		request.setAttribute("rpp", rpp);
		return "sys/roleManager/index.jsp";
	}
	//添加角色
	@RequestMapping("/addRole.action")
	public String addRole(RolePojo mp,HttpServletRequest request){
		//System.out.println(""+mp.getM_father()+"--"+mp.getM_state());
		UserPojo  up= (UserPojo)request.getSession().getAttribute("loginUser");
		System.out.println(up.getU_realname());
		mp.setR_createname(up.getU_loginname());
		UserPojo user=(UserPojo)request.getSession().getAttribute("loginUser");
		int userid=user.getU_id();
		int a=roleService.addRole(mp);
		if(a>0){
			logService.insertLog("添加角色", userid);
			return "redirect:getAllRoles.action";
		}else{
			return "addRole.action";
		}
	}
	//跳转到修改页面
	@RequestMapping("/toUpdateRole.action")
	public String toUpdateMenu( HttpServletRequest request){
		String id=request.getParameter("rid");
		int a=-1;
		if(id != null){
			a=Integer.parseInt(id);
		}
		RolePojo r=roleService.getRoleById(a);
		request.setAttribute("role", r);
		return "sys/roleManager/update.jsp";
	}
	//修改角色
	@RequestMapping("/updateRole.action")
	public String updateRole(RolePojo rp,HttpServletRequest request){
		int a=roleService.updateRole(rp);
		roleService.updateUserRole(rp);
		UserPojo user=(UserPojo)request.getSession().getAttribute("loginUser");
		int userid=user.getU_id();
		if(a>0){
			logService.insertLog("修改角色", userid);
			//logController.insertLog("修改角色", request);
			return "redirect:getAllRoles.action";
		}else{
			return "toUpdateRole.action";
		}
		
	}
	
	//删除角色
	@RequestMapping("/deleteRole.action")
	public String deleteRole(HttpServletRequest request){
		String id=request.getParameter("rid");
		int a=-1;
		if(id != null){
			a=Integer.parseInt(id);
		}
		UserPojo user=(UserPojo)request.getSession().getAttribute("loginUser");
		int userid=user.getU_id();
		logService.insertLog("删除角色", userid);
		//删除角色下的用户
		RolePojo rp=new RolePojo();
		rp.setR_id(a);
		rp.setR_state(2);
		roleService.updateUserRole(rp);
		//删除中间表
		rolePermissionsService.deleteRoleMenu(a);
		int b=roleService.deleteRole(a);
		return "getAllRoles.action";
	}
	//到添加页面得到角色编号
	@RequestMapping("/toAddRole.action")
	public String toAddRole(HttpServletRequest request){
		List<RolePojo> roleList=roleService.findAllRoles3();
		int ss=roleList.size();
		RolePojo rp=roleList.get(ss-1);
		int id=rp.getR_id()+1;
		String num="ro";
		if(id>9){
			num=num+id;
		}else{
			num=num+"0"+id;
		}
		request.setAttribute("rolenumber", num);
		return "sys/roleManager/add.jsp";
	}
	
	//角色名称的唯一性
	@RequestMapping("/roleNameOnly.action")
	public void roleNameOnly(String rname,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		//输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		rname=rname.replaceAll(" ", "");
		//查询所有的  回显  查询
		List<RolePojo> roleList=roleService.findAllRoles2();
		String isok="ok";
		for (int i = 0; i < roleList.size(); i++) {
			if(rname.equals(roleList.get(i).getR_name())){
				isok="no";
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
	@RequestMapping("/roleNameOnly2.action")
	public void roleNameOnly2(String rname,int rid,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		//输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		rname=rname.replaceAll(" ", "");
		//查询所有的  回显  查询
		List<RolePojo> roleList=roleService.findAllRoles2();
		String isok="ok";
		
		for (int i = 0; i < roleList.size(); i++) {
			if(roleList.get(i).getR_id() == rid){
				roleList.remove(i);				
			}			
		}
		for(int i = 0; i < roleList.size(); i++){
			if(roleList.get(i).getR_name().equals(rname)){
				isok="no";
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
