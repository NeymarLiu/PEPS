package com.zrgk.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zrgk.pojo.UserPojo;
import com.zrgk.service.LoginUserService;
import com.zrgk.service.UserService;

@Controller
public class LoginUserController {
       @Autowired   
	  private LoginUserService loginUserService;
       @Autowired
       private UserService userService;
       
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public LoginUserService getLoginUserService() {
		return loginUserService;
	}

	public void setLoginUserService(LoginUserService loginUserService) {
		this.loginUserService = loginUserService;
	}  
	
	
	//登陆
	@RequestMapping("/login.action")
	public String login(UserPojo up,String remenber,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		UserPojo user=loginUserService.login(up);
		if(user!=null){
			String name=up.getU_loginname();
			String ps=up.getU_password();
			int us=user.getU_state();
			if(us==0){
			//存cookie对象
			Cookie ck[] = request.getCookies();
			boolean b=true;
			if(remenber!=null){
			//判断ck 是否为空
			if(ck!=null){//cookie不能为空 记录的是上次登录时间
				for( Cookie c :ck){//循环ck 加强for循环
					//如果存在此Cookie 更新值
					if("name".equals(c.getName())){
						 c = new Cookie("name", name);
						c.setMaxAge(60*24*60*7);
						Cookie c2 = new Cookie("ps", ps);
						c2.setMaxAge(60*24*60*7);
						response.addCookie(c);
						response.addCookie(c2);
						b=false;
				   }
				} 
				//如果不存在对应得Cookie new一个
				if(b){
					Cookie c = new Cookie("name", name);
					c.setMaxAge(60*24*60*7);
					Cookie c2 = new Cookie("ps", ps);
					c2.setMaxAge(60*24*60*7);
					response.addCookie(c);
					response.addCookie(c2);
				}
			}else{
				Cookie c = new Cookie("name", name);
				c.setMaxAge(60*24*60*7);
				Cookie c2 = new Cookie("ps", ps);
				c2.setMaxAge(60*24*60*7);
				response.addCookie(c);
				response.addCookie(c2);
			}
		}else{
				if(ck!=null){
					for( Cookie c :ck){
						if("name".equals(c.getName())){
							c.setMaxAge(0);
							response.addCookie(c);
						}
						if("ps".equals(c.getName())){
							c.setMaxAge(0);
							response.addCookie(c);
						}
					}
				}
			}
			userService.updateUserTime(user.getU_id());
			session.setAttribute("loginUser", user);
			return "getUserMenus.action";
		}else if(us==1){
				request.setAttribute("error", "用户已被限制登录,请联系管理员!");
				return "/login.jsp";
			}else{
				request.setAttribute("error","用户名或密码错误!");
				return "/login.jsp";
			}
			
		}else{
			request.setAttribute("error","用户名或密码错误!");
			return "/login.jsp";
		}
	}
	   //退出
		@RequestMapping("/tc.action")
	   public String tcUser(HttpServletRequest request){
			request.getSession().removeAttribute("loginUser");
			return "/login.jsp";
	   }
		
}
