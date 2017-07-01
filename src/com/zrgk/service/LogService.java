package com.zrgk.service;

import java.util.List;

import com.zrgk.pojo.LogPageParams;
import com.zrgk.pojo.LogPojo;
import com.zrgk.util.PartPage;

public interface LogService {

	//插入日志
	//public int insertLog(LogPojo lp);
	public int insertLog(String name,int uid);
	//根据id得到所有的用户日志
	public List<LogPojo> getAllLogById(LogPageParams lpp);
	public int getCount(LogPageParams lpp);
	
	public PartPage getPartPage(int count,int page);
}
