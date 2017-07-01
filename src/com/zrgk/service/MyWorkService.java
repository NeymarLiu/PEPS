package com.zrgk.service;

import java.util.List;

import com.zrgk.pojo.FuzzyMyworkParams;
import com.zrgk.pojo.MyTaskPojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.util.PartPage;

public interface MyWorkService {
	//修改用户
		public  int updateMyUser(UserPojo up);
	//通过查询用户
	public UserPojo selectMyUser(int id);
	//代办列表巡检任务查看
	public List<MyTaskPojo> AllXjTask(FuzzyMyworkParams fmp);
	public int AllXjTaskCount(FuzzyMyworkParams fmp);
	//通过id查看代办列表详情
	public MyTaskPojo AllXjTaskId(int p_id);
	//分页
	public PartPage getPartPage(int count,int page);
	
	public int  checkLoginName(UserPojo up);
	
	public List<MyTaskPojo> getEDTask(FuzzyMyworkParams fmp);
	
	public int getEDTaskCount(FuzzyMyworkParams fmp);
	
	public MyTaskPojo getOneEDTask(FuzzyMyworkParams fmp);
	
	public List<MyTaskPojo> AllXjPTask(FuzzyMyworkParams fmp);
	
	public int AllXjPTaskCount(FuzzyMyworkParams fmp);
	
	public List<MyTaskPojo> getEDETask(FuzzyMyworkParams fmp);
	
	public int getEDETaskCount(FuzzyMyworkParams fmp);
	
	public MyTaskPojo getOneEDETask(FuzzyMyworkParams fmp);
	
}
