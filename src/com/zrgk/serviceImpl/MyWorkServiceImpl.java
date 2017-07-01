package com.zrgk.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.MyWorkMapper;
import com.zrgk.pojo.FuzzyMyworkParams;
import com.zrgk.pojo.MyTaskPojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.MyWorkService;
import com.zrgk.util.PartPage;
@Service
public class MyWorkServiceImpl implements MyWorkService {
	@Autowired 
	public MyWorkMapper myWorkMapper;
	 
	public MyWorkMapper getMyWorkspaceMapper() {
		return myWorkMapper;
	}
	public void setMyWorkspaceMapper(MyWorkMapper myWorkMapper) {
		this.myWorkMapper = myWorkMapper;
	}
	
	//修改个人用户s
	@Override
	public int updateMyUser(UserPojo up) {
		// TODO Auto-generated method stub
		return myWorkMapper.updateMyUser(up);
	}
	//通过查询用户
	@Override
	public UserPojo selectMyUser(int id) {
		// TODO Auto-generated method stub
		return myWorkMapper.selectMyUser(id);
	}
	//通过id查看代办列表详情
	@Override
	public MyTaskPojo AllXjTaskId(int p_id) {
		// TODO Auto-generated method stub
		return myWorkMapper.AllXjTaskId(p_id);
	}
	@Override
	public List<MyTaskPojo> AllXjTask(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.AllXjTask(fmp);
	}
	@Override
	public int AllXjTaskCount(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.AllXjTaskCount(fmp);
	}
	@Override
	public PartPage getPartPage(int count, int page) {
		PartPage p=new PartPage();
		int pages=0;
		if(count!=0){
			if (count%PartPage.pageSize!=0) {
				pages=count/PartPage.pageSize+1;
			}else {
				pages=count/PartPage.pageSize;
			}
			if(page<1){
				page=1;
			}else if (page>pages) {
				page=pages;
			}
			p.setCount(count);
			p.setNowPage(page);
			p.setTotalPage(pages);
		}else {
			p.setCount(0);
			p.setNowPage(1);
			p.setTotalPage(1);
		}
		return p;
	}
	@Override
	public int checkLoginName(UserPojo up) {
		// TODO Auto-generated method stub
		return myWorkMapper.checkLoginName(up);
	}
	@Override
	public List<MyTaskPojo> getEDTask(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.getEDTask(fmp);
	}
	@Override
	public int getEDTaskCount(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.getEDTaskCount(fmp);
	}
	@Override
	public MyTaskPojo getOneEDTask(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.getOneEDTask(fmp);
	}
	@Override
	public List<MyTaskPojo> AllXjPTask(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.AllXjPTask(fmp);
	}
	@Override
	public int AllXjPTaskCount(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.AllXjPTaskCount(fmp);
	}
	@Override
	public List<MyTaskPojo> getEDETask(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.getEDETask(fmp);
	}
	@Override
	public int getEDETaskCount(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.getEDETaskCount(fmp);
	}
	@Override
	public MyTaskPojo getOneEDETask(FuzzyMyworkParams fmp) {
		// TODO Auto-generated method stub
		return myWorkMapper.getOneEDETask(fmp);
	}
	

}
