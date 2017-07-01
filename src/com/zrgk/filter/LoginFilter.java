package com.zrgk.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgk.pojo.UserPojo;


/**
 * @author liucan
 * @version 2016年11月25日11:12:35
 * */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
    	HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        //System.out.println(path);
        
        // 从session用户
        UserPojo ub= (UserPojo) session.getAttribute("loginUser");

        /*创建类Constants.java，里面写的是无需过滤的页面
        for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {

            if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
                chain.doFilter(servletRequest, servletResponse);
                return;
            }
        }*/
        
        // 登陆页面无需过滤
       // ||path.indexOf("ValidateNumberServlet.do")>-1
        if(path.indexOf("/login.jsp") > -1
        		||path.indexOf("login.action")>-1
        		||path.endsWith("js")
        		||path.indexOf("css")>-1
        		||path.indexOf("png")>-1
        		||path.indexOf("jpg")>-1
        		) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 判断如果没有取到用户信息,就跳转到登陆页面
        if (ub == null || "".equals(ub)) {
            // 跳转到登陆页面
        	request.setAttribute("flag", "1");
//        PrintWriter  out	=servletResponse.getWriter();
//        out.write(1);
//        out.flush();
//        out.close();  ajax  做的写输出  跳转
        	//log4j
        servletRequest.getRequestDispatcher("/login.jsp").forward(request, response);
        	//servletResponse.sendRedirect("/login.jsp");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}