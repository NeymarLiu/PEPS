package com.zrgk.service;

import java.util.List;

import com.zrgk.pojo.FlawSureParams;
import com.zrgk.pojo.PatrolFlawPojo;
import com.zrgk.util.PartPage;

public interface FlawLevelService {
	//得到任务确认缺陷信息
	public List<PatrolFlawPojo> getAllPatrolFlawPojo(FlawSureParams fsp);
	//得到总数
	public int getAllPatrolFlawPojoCount(FlawSureParams fsp);
	//分页
	public PartPage getPartPage(int count, int page);
	//添加
	public int sureFlaw(PatrolFlawPojo pfp);
	//通过塔杆编码得到确认信息
	public int getUnSureCount(int p_id);
}
