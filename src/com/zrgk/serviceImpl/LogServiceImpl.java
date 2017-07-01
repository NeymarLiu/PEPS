package com.zrgk.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.LogMapper;
import com.zrgk.pojo.LogPageParams;
import com.zrgk.pojo.LogPojo;
import com.zrgk.service.LogService;
import com.zrgk.util.PartPage;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogMapper logMapper;
	
	public LogMapper getLogMapper() {
		return logMapper;
	}

	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}

	//插入日志    当前用户id   操作的内容   info
	@Override
	public int insertLog(String info, int uid) {
		LogPojo lp=new LogPojo();		
		lp.setU_id(uid);
		lp.setLog_info(info);
		System.out.println(lp.getU_id()+"---"+lp.getLog_info());
		int a=logMapper.insertLog(lp);
		return a;
	}

	@Override
	public List<LogPojo> getAllLogById(LogPageParams lpp) {
		// TODO Auto-generated method stub
		return logMapper.getAllLogById(lpp);
	}

	@Override
	public int getCount(LogPageParams lpp) {
		// TODO Auto-generated method stub
		return logMapper.getCount(lpp);
	}

	@Override
	public PartPage getPartPage(int count, int page) {
		// TODO Auto-generated method stub
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

	/*@Override
	public int insertLog(LogPojo lp) {
		// TODO Auto-generated method stub
		return logMapper.insertLog(lp);
	}*/

}
