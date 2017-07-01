package com.zrgk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.PoleMapper;
import com.zrgk.pojo.FuzzyPoleParams;
import com.zrgk.pojo.LinePojo;
import com.zrgk.pojo.PolePojo;
import com.zrgk.service.PoleService;
import com.zrgk.util.PartPage;
@Service
public class PoleServiceImpl implements PoleService{

	@Autowired
	private PoleMapper poleMapper;
	
	public PoleMapper getPoleMapper() {
		return poleMapper;
	}

	public void setPoleMapper(PoleMapper poleMapper) {
		this.poleMapper = poleMapper;
	}

	@Override
	public List<PolePojo> getAllLine() {
		// TODO Auto-generated method stub
		return poleMapper.getAllLine();
	}

	@Override
	public PolePojo getPolePojo(int id) {
		// TODO Auto-generated method stub
		return poleMapper.getPolePojo(id);
	}

	@Override
	public List<PolePojo> getAllPolePojo(FuzzyPoleParams fpp) {
		// TODO Auto-generated method stub
		return poleMapper.getAllPolePojo(fpp);
	}

	@Override
	public int getAllPolePojoCount(FuzzyPoleParams fpp) {
		// TODO Auto-generated method stub
		return poleMapper.getAllPolePojoCount(fpp);
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
	public int updatePole(PolePojo pp) {
		// TODO Auto-generated method stub
		return poleMapper.updatePole(pp);
	}

	@Override
	public int updatePoleInfo(PolePojo pp) {
		// TODO Auto-generated method stub
		return poleMapper.updatePoleInfo(pp);
	}

	@Override
	public int addPole(PolePojo pp) {
		// TODO Auto-generated method stub
		return poleMapper.addPole(pp);
	}

	@Override
	public String getLineId(String li_code) {
		// TODO Auto-generated method stub
		return poleMapper.getLineId(li_code);
	}

	@Override
	public PolePojo getPolePojoByPP(PolePojo pp) {
		// TODO Auto-generated method stub
		return poleMapper.getPolePojoByPP(pp);
	}

	
}
