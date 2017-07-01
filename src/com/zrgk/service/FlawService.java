package com.zrgk.service;

import java.util.List;

import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.FuzzyFlawParams;
import com.zrgk.util.PartPage;

public interface FlawService {
	//得到缺陷类型信息
	public List<FlawPojo> getAllFlawPojo(FuzzyFlawParams ffp);
	//得到缺陷类型信息
	public int getAllFlawPojoCount(FuzzyFlawParams ffp);
	//分页
	public PartPage getPartPage(int count,int page);
	//添加类型
	public int addFlawPojo(FlawPojo fp);
	//根据名字查询
	public String checkFName(FlawPojo fw);
	//通过ID得到缺陷信息
	public FlawPojo toUpdateFlawPojo(int f_id);
	//修改
	public int UpdateFlawPojo(FlawPojo fp);
	//修改
	public int UpdateFlawPojo2(FlawPojo fp);
}
