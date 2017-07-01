package com.zrgk.mapper;

import java.util.List;

import com.zrgk.pojo.FlawSureParams;
import com.zrgk.pojo.PatrolFlawPojo;

public interface FlawLevelMapper {
	//得到任务确认缺陷信息
	public List<PatrolFlawPojo> getAllPatrolFlawPojo(FlawSureParams fsp);
	//得到总数
	public int getAllPatrolFlawPojoCount(FlawSureParams fsp);
	//添加
	public int sureFlaw(PatrolFlawPojo pfp);
	//通过塔杆编码得到确认信息
	public int getUnSureCount(int p_id);
}
