package com.zrgk.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zrgk.pojo.FuzzyPoleParams;
import com.zrgk.pojo.PolePojo;
@Component
public interface PoleMapper {
	//得到所有塔杆信息
	public List<PolePojo> getAllPolePojo(FuzzyPoleParams fpp);
	//得到所有塔杆信息记录数
	public int  getAllPolePojoCount(FuzzyPoleParams fpp);
	//根据id获取塔杆信息
	public PolePojo getPolePojo(int id);
	//得到所有线路
	public List<PolePojo> getAllLine();
	//更改塔杆状态
	public int updatePole(PolePojo pp);
	//
	public int updatePoleInfo(PolePojo pp);
	//添加塔杆
	public int addPole(PolePojo pp);
	//根据线路code 得到线路id
	public String getLineId(String li_code);
	//根据塔杆编号获取塔杆信息
	public PolePojo getPolePojoByPP(PolePojo pp);
}
