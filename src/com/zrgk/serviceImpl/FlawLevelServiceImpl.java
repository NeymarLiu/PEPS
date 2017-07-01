package com.zrgk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.FlawLevelMapper;
import com.zrgk.pojo.FlawSureParams;
import com.zrgk.pojo.PatrolFlawPojo;
import com.zrgk.service.FlawLevelService;
import com.zrgk.util.PartPage;
@Service
public class FlawLevelServiceImpl implements FlawLevelService{
	@Autowired
	private FlawLevelMapper flawLevelMapper;
	public FlawLevelMapper getFlawLevelMapper() {
		return flawLevelMapper;
	}
	public void setFlawLevelMapper(FlawLevelMapper flawLevelMapper) {
		this.flawLevelMapper = flawLevelMapper;
	}
	@Override
	public List<PatrolFlawPojo> getAllPatrolFlawPojo(FlawSureParams fsp) {
		// TODO Auto-generated method stub
		return flawLevelMapper.getAllPatrolFlawPojo(fsp);
	}
	@Override
	public int getAllPatrolFlawPojoCount(FlawSureParams fsp) {
		// TODO Auto-generated method stub
		return flawLevelMapper.getAllPatrolFlawPojoCount(fsp);
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
	public int sureFlaw(PatrolFlawPojo pfp) {
		// TODO Auto-generated method stub
		return flawLevelMapper.sureFlaw(pfp);
	}
	@Override
	public int getUnSureCount(int p_id) {
		// TODO Auto-generated method stub
		return flawLevelMapper.getUnSureCount(p_id);
	}
	
}
