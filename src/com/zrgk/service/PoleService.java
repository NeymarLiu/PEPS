package com.zrgk.service;

import java.util.List;

import com.zrgk.pojo.FuzzyPoleParams;
import com.zrgk.pojo.LinePojo;
import com.zrgk.pojo.PolePojo;
import com.zrgk.util.PartPage;

public interface PoleService {
	//得到所有塔杆信息
	public List<PolePojo> getAllPolePojo(FuzzyPoleParams fpp);
		//得到所有塔杆信息记录数
	public int  getAllPolePojoCount(FuzzyPoleParams fpp);
	//根据id获取塔杆信息
	public PolePojo getPolePojo(int id);
	//得到所有线路
	public List<PolePojo> getAllLine();
	//分页
	public PartPage getPartPage(int count,int page);
	//更改塔杆状态
	public int updatePole(PolePojo pp);
	//更改塔杆信息
	public int	updatePoleInfo(PolePojo pp);
	//添加塔杆信息
	public int addPole(PolePojo pp);
	//根据线路code 得到线路id
	public String getLineId(String li_code);
	//根据塔杆编号获取塔杆信息
	public PolePojo getPolePojoByPP(PolePojo pp);
}
