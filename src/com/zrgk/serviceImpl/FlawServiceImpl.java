package com.zrgk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.FlawMapper;
import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.FuzzyFlawParams;
import com.zrgk.service.FlawService;
import com.zrgk.util.PartPage;
@Service
public class FlawServiceImpl implements FlawService{
	@Autowired
	private FlawMapper flawMapper;
	public FlawMapper getFlawMapper() {
		return flawMapper;
	}
	public void setFlawMapper(FlawMapper flawMapper) {
		this.flawMapper = flawMapper;
	}
	@Override
	public List<FlawPojo> getAllFlawPojo(FuzzyFlawParams ffp) {
		// TODO Auto-generated method stub
		return flawMapper.getAllFlawPojo(ffp);
	}
	@Override
	public int getAllFlawPojoCount(FuzzyFlawParams ffp) {
		// TODO Auto-generated method stub
		return flawMapper.getAllFlawPojoCount(ffp);
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
	public int addFlawPojo(FlawPojo fp) {
		// TODO Auto-generated method stub
		return flawMapper.addFlawPojo(fp);
	}
	@Override
	public String checkFName(FlawPojo fw) {
		// TODO Auto-generated method stub
		return flawMapper.checkFName(fw);
	}
	@Override
	public FlawPojo toUpdateFlawPojo(int f_id) {
		// TODO Auto-generated method stub
		return flawMapper.toUpdateFlawPojo(f_id);
	}
	@Override
	public int UpdateFlawPojo(FlawPojo fp) {
		// TODO Auto-generated method stub
		return flawMapper.UpdateFlawPojo(fp);
	}
	@Override
	public int UpdateFlawPojo2(FlawPojo fp) {
		// TODO Auto-generated method stub
		return flawMapper.UpdateFlawPojo2(fp);
	}
}
