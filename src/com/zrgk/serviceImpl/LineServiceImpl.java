package com.zrgk.serviceImpl;

import java.util.ArrayList;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.LineMapper;

import com.zrgk.pojo.LinePojo; 
import com.zrgk.pojo.Linecanshu;
import com.zrgk.pojo.MenuPojo;
import com.zrgk.pojo.PolePojo;
import com.zrgk.service.LineService;
import com.zrgk.util.PartPage;


@Service
public class LineServiceImpl implements LineService{
	@Autowired
	private LineMapper lineMapper;
	
	
	
	public LineMapper getLineMapper() {
		return lineMapper;
	}



	public void setLineMapper(LineMapper lineMapper) {
		this.lineMapper = lineMapper;
	}



	@Override
	public List<LinePojo> getAllLine(Linecanshu lc) {
		// TODO Auto-generated method stub
		return lineMapper.getAllLine(lc);

}

	
	

	@Override
	public int getAlllineCount(Linecanshu lc){
		// TODO Auto-generated method stub
		return  lineMapper.getAlllineCount(lc);
	}



	


	@Override
	public List<LinePojo> getLIByname(String liname) {
		// TODO Auto-generated method stub
		return  lineMapper.getLIByname(liname);
	}



	@Override
	public int addLine(LinePojo li) {
		// TODO Auto-generated method stub
		return lineMapper.addLine(li);
	}
	
	@Override
	public PartPage getPartPage(int count, int page) {
		PartPage p=new PartPage();
		int pages=0;
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
		System.out.println(page);
		p.setCount(count);
		p.setNowPage(page);
		p.setTotalPage(pages);
		return p;
	}



	@Override
	public LinePojo getLineById(int id) {
		// TODO Auto-generated method stub
		return lineMapper.getLineById(id);
	}



	@Override
	public int deleteLine(int id) {
		// TODO Auto-generated method stub
		return lineMapper.deleteLine(id);
	}



	@Override
	public int getmaxLi_id() {
		// TODO Auto-generated method stub
		return  (lineMapper.getmaxLi_id()+1);
	}



	@Override
	public int updateLine(LinePojo lp) {
		// TODO Auto-generated method stub
		return lineMapper.updateLine(lp);
	}



	@Override
	public List<LinePojo> findAllLine() {
		// TODO Auto-generated method stub
		return lineMapper.findAllLine();
	}



	@Override
	public List<LinePojo> findAllFatherLine()  {
		// TODO Auto-generated method stub
		List<LinePojo> list= lineMapper.findAllLine();
		List<LinePojo> lplist=new ArrayList<LinePojo>();
		
		 
		return lplist;
	}



	@Override
	public int lineState(LinePojo lp) {
		// TODO Auto-generated method stub
		return  lineMapper.lineState(lp);
	}



	@Override
	public int  selectlicode(LinePojo lp) {
		return lineMapper.selectlicode(lp);
	}



	@Override
	public int  selectlicode2(LinePojo lp) {
		// TODO Auto-generated method stub
		return  lineMapper.selectlicode2(lp);
	}

	
	
}
