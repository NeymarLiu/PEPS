package com.zrgk.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zrgk.pojo.FuzzyFlawParams;
import com.zrgk.pojo.FuzzyMyworkParams;
import com.zrgk.pojo.MyTaskPojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.MyWorkService;
import com.zrgk.util.PartPage;
	@Controller
	public class MyWorkController {
    @Autowired
	public MyWorkService myWorkService;

	public MyWorkService getMyWorkService() {
		return myWorkService;
	}

	public void setMyWorkService(MyWorkService myWorkService) {
		this.myWorkService = myWorkService;
	}
	//查用户信息
	@RequestMapping("/selectMyUser.action")
	public String selectMyUser(HttpSession session,HttpServletRequest request){
		//取session
		UserPojo userPojo=(UserPojo)session.getAttribute("loginUser");
		int id=userPojo.getU_id();
		UserPojo user= myWorkService.selectMyUser(id);
	
		request.getSession().setAttribute("user", user);
		    
		return "mywork/user.jsp";
	}
	//修改用户信息
	@RequestMapping("/updateMyUser.action")
	public String updateUser(HttpSession session, UserPojo up,HttpServletRequest request ){
		int u = myWorkService.updateMyUser(up);
		if(u>0){
			request.getSession().removeAttribute("loginUser");
			request.setAttribute("flag", 1);
	 		return "login.jsp";
		}else{
			return "selectMyUser.action" ;
		}
	}
	//代办列表中 查看巡检任务
	@RequestMapping("/patcolTask.action")
	public String getAllPatrolTask(HttpServletRequest request ,String nowPage,FuzzyMyworkParams fmp){
		//当前页码	
		int page=1;
		if(nowPage!=null){
			page=Integer.parseInt(nowPage);
		}
		//得到当前用户的角色
		int rid=((UserPojo)request.getSession().getAttribute("loginUser")).getRolePojo().getR_id();
		PartPage partPage=null;
		//如果是线路管理员
		if(rid==2){
			fmp.setU_id(((UserPojo)request.getSession().getAttribute("loginUser")).getU_id());
			//得到总记录数
			
			fmp.setState(new int []{1,4});
			int count =myWorkService.AllXjTaskCount(fmp);
			fmp.setState(new int []{1});
			int count2=myWorkService.getEDETaskCount(fmp);
			count+=count2;
			partPage=myWorkService.getPartPage(count, page);
			if(count!=0){
				fmp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize());
				fmp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
				fmp.setState(new int []{1,4});
				List<MyTaskPojo>mList= myWorkService.AllXjTask(fmp);
				fmp.setState(new int []{1});
				List<MyTaskPojo>mList2= myWorkService.getEDETask(fmp);
				List<MyTaskPojo>list=new ArrayList<MyTaskPojo>();
				if(fmp.getEndNumber()>count){
					fmp.setEndNumber(count);
				}
				if(mList!=null){
					for (int i = 0; i < mList.size(); i++) {
						MyTaskPojo mtp=mList.get(i);
						mtp.setGetOne("patcolId.action?p_id="+mtp.getP_id());
						mtp.setToOne("getAllPatrol.action");
						mtp.setTaskName("巡检任务");
					}
				}
				if(mList2!=null){
					for (int i = 0; i < mList2.size(); i++) {
						MyTaskPojo mtp=mList2.get(i);
						mtp.setGetOne("getOneEDETask.action?p_id="+mtp.getP_id());
						mtp.setToOne("moHuEdTask.action");
						mtp.setTaskName("消缺任务");
						mList.add(mtp);
					}
				}
				if(mList!=null){
					for (int i = fmp.getStartNumber(); i < fmp.getEndNumber(); i++) {
						MyTaskPojo mtp=mList.get(i);
						list.add(mtp);
					} 
					
				}
				request.setAttribute("mytks",list);
			}
		}else if(rid==3){
			fmp.setU_id(((UserPojo)request.getSession().getAttribute("loginUser")).getU_id());
			//巡检员
			fmp.setState(new int []{2,3});
			//得到总记录数
			int count =myWorkService.AllXjPTaskCount(fmp);
			partPage=myWorkService.getPartPage(count, page);
			if(count!=0){
				fmp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize());
				fmp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
				List<MyTaskPojo>mList= myWorkService.AllXjPTask(fmp);
				List<MyTaskPojo>list=new ArrayList<MyTaskPojo>();
				if(fmp.getEndNumber()>count){
					fmp.setEndNumber(count);
				}
				for (int i = fmp.getStartNumber(); i < fmp.getEndNumber(); i++) {
					MyTaskPojo mtp=mList.get(i);
					mtp.setGetOne("patcolId.action?p_id="+mtp.getP_id());
					mtp.setToOne("getAllPTask.action");
					mtp.setTaskName("巡检任务");
					list.add(mtp);
				} 
				request.setAttribute("mytks",list);
			}
		}else if(rid==4){
			fmp.setU_id(((UserPojo)request.getSession().getAttribute("loginUser")).getU_id());
			//得到总记录数
			int count =myWorkService.getEDTaskCount(fmp);
			partPage=myWorkService.getPartPage(count, page);
			if(count!=0){
				fmp.setStartNumber((partPage.getNowPage()-1)*partPage.getPageSize());
				fmp.setEndNumber(partPage.getNowPage()*partPage.getPageSize());
				List<MyTaskPojo>mlist=myWorkService.getEDTask(fmp);
				List<MyTaskPojo>list=new ArrayList<MyTaskPojo>();
				if(fmp.getEndNumber()>count){
					fmp.setEndNumber(count);
				}
				for (int i = fmp.getStartNumber(); i < fmp.getEndNumber(); i++) {
					MyTaskPojo mtp=mlist.get(i);
					mtp.setGetOne("getOneEDTask.action?p_id="+mtp.getP_id());
					mtp.setToOne("moHuEdTaskUser.action");
					mtp.setTaskName("消缺任务");
					list.add(mtp);
					request.setAttribute("mytks", list);
				}
			}
		
		}
		request.setAttribute("fmp", fmp);
		request.setAttribute("page", partPage);
		return "mywork/task.jsp";
		
	}
	@RequestMapping("/patcolId.action")
	public String getAllPatrol(HttpServletRequest request ,int p_id){
		MyTaskPojo mtp = myWorkService.AllXjTaskId(p_id);
		request.setAttribute("mt", mtp);
		return "mywork/look.jsp";
	}
	 //ajax验证用户密码是否唯一
	@ResponseBody
	@RequestMapping("/checkLoginName.action")
		public String checkLoginName(HttpServletRequest request ,UserPojo up ) throws IOException{
		return myWorkService.checkLoginName(up)+"";
		
	}
	@RequestMapping("/getOneEDTask.action")
	public String getOneEDTask(HttpServletRequest request ,FuzzyMyworkParams fmp){
		fmp.setU_id(((UserPojo)request.getSession().getAttribute("loginUser")).getU_id());
		MyTaskPojo mtp = myWorkService.getOneEDTask(fmp);
		request.setAttribute("mt", mtp);
		return "mywork/look.jsp";
	}
	@RequestMapping("/getOneEDETask.action")
	public String getOneEDETask(HttpServletRequest request ,FuzzyMyworkParams fmp){
		fmp.setU_id(((UserPojo)request.getSession().getAttribute("loginUser")).getU_id());
		MyTaskPojo mtp = myWorkService.getOneEDETask(fmp);
		request.setAttribute("mt", mtp);
		return "mywork/look.jsp";
	}
	
}
