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
import com.zrgk.pojo.RolePojo;
import com.zrgk.pojo.UserPageParams;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.LogService;
import com.zrgk.service.RoleService;
import com.zrgk.service.UserService;
import com.zrgk.util.PartPage;
/**
 * 
 * @author longwenyu
 * @version 
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private LogService logService;
	
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//得到所有用户信息
	@RequestMapping("/getAllUsers.action")
	public String getAllUsers(String nowPage,UserPageParams upp,HttpServletRequest request,HttpServletResponse response){
		String type=request.getParameter("type");
		if(upp.getU_realname() != null){
			String n=upp.getU_realname();
			upp.setU_realname(n.replaceAll(" ", ""));
			System.out.println(upp.getU_realname());
		}
		if("add".equals(type) || "update".equals(type)){
			upp.setU_realname(null);			
		}
		int page=1;
		if(nowPage != null){
			page=Integer.parseInt(nowPage);
		}
		int count =userService.getCount(upp);
		PartPage partPage=userService.getPartPage(count, page);
		upp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize()+1);
		upp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
		List<UserPojo> roleList=userService.getAllUsers(upp);				
		request.setAttribute("page", partPage);
		request.setAttribute("action", "getAllUsers");
		request.setAttribute("uList", roleList);
		request.setAttribute("upp", upp);
		return "sys/userManager/index.jsp";
	}
	//跳转到添加页面
	@RequestMapping("/toAddUser.action")
	public String toAddUser(HttpServletRequest request){
		List<RolePojo> rList=roleService.findAllRoles();
		request.setAttribute("rList", rList);
		return "sys/userManager/add.jsp";
	}
	//添加用户信息
	@RequestMapping("/addOneUser.action")
	public String addOneUser(UserPojo up,HttpServletRequest request){
		
		int a=userService.addOneUser(up);
		UserPojo user=(UserPojo)request.getSession().getAttribute("loginUser");
		int userid=user.getU_id();
		if(a>0){
			logService.insertLog("添加用户信息", userid);
			return "redirect:getAllUsers.action";
		}else{
			return "toAddUser.action";
		}
		
	}
	//跳转到修改页面
	@RequestMapping("/toUpdateUser.action")
	public String toUpdateUser(int uid,HttpServletRequest request){
		UserPojo up=userService.getUserById(uid);
		List<RolePojo> rList=roleService.findAllRoles();
		request.setAttribute("rList", rList);
		request.setAttribute("up", up);
		return "sys/userManager/update.jsp";
	}
	//修改用户信息
	@RequestMapping("/updateUser.action")
	public String updateUser(UserPojo up,HttpServletRequest request){
		int a=userService.updateUser(up);
		UserPojo user=(UserPojo)request.getSession().getAttribute("loginUser");
		int userid=user.getU_id();
		if(a>0){
			logService.insertLog("修改用户信息", userid);
			return "redirect:getAllUsers.action";
		}else{
			return "toUpdateUser.action";
		}	
	}
	//修改用户状态
	@RequestMapping("/updateUserState.action")
	public String updateUserState(UserPojo up){
		int a=userService.updateUserState(up);
		return "redirect:getAllUsers.action";
	}
	//删除用户信息
	@RequestMapping("/deleteUser.action")
	public String deleteUser(int uid,HttpServletRequest request){
		UserPojo user=(UserPojo)request.getSession().getAttribute("loginUser");
		int userid=user.getU_id();
		logService.insertLog("删除用户信息", userid);
		int a=userService.deleteUser(uid);
		return "redirect:getAllUsers.action";
	}
	
	
	//登录用户名唯一性验证
	@RequestMapping("/loginName.action")
	public void loginName(String name,HttpServletRequest request,HttpServletResponse response) throws IOException{
		//输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//查询所有的  回显  查询
		List<UserPojo> list=userService.findAllUser();
		String isok="ok";
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getU_loginname().equals(name)){
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
	

	//登录用户名唯一性验证
	@RequestMapping("/loginName2.action")
	public void loginName2(String name,int id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		//输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//查询所有的  回显  查询
		List<UserPojo> list=userService.findAllUser();
		String isok="ok";
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getU_id()==id){
				list.remove(i);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getU_loginname().equals(name)){
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
