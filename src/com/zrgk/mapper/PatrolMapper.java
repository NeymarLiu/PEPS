package com.zrgk.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.FuzzyPartPTaskParams;
import com.zrgk.pojo.InformationStatisticsParams;
import com.zrgk.pojo.LinePojo;
import com.zrgk.pojo.LogPojo;
import com.zrgk.pojo.PatrolFlawPojo;
import com.zrgk.pojo.PatrolQueryPojo;
import com.zrgk.pojo.PatrolTaskPojo;
import com.zrgk.pojo.PatrolUserPojo;
import com.zrgk.pojo.PolePojo;
import com.zrgk.pojo.UserPojo;

/**
 * @author liucan
 * @version 2016年11月23日13:49:53
 * */
@Component
public interface PatrolMapper {
	//得到所有巡检任务
	public List<PatrolTaskPojo> getAllPatrolTask(FuzzyPartPTaskParams fptp);
	//得到所有巡检任务记录数
	public int getAllPatrolTaskCount(FuzzyPartPTaskParams fptp);
	//根据id查询巡检任务详情
	public PatrolTaskPojo getOnePatrolTask(int pid);
	//得到所有的巡检员
	public List<UserPojo> getPatrolPeople();
	//得到所有线路
	public List<LinePojo> getAllLine();
	//根据线路编号查询对于的塔杆集合
	public List<PolePojo> getPojoByLine(int lid);
	//得到最大id
	public String getMaxTaskID();
	//添加巡检任务
	public int addPatrolTask(PatrolTaskPojo ptp);
	//根据巡检任务编号查询id
	public int getPidByPcode(String p_num);
	//添加执行任务的巡检人员c
	public int addTaskUser(PatrolUserPojo pup);
	//得到需要巡检的塔杆集合
	public List<PolePojo> getTaskPole(PatrolTaskPojo ptp);
	//添加需要巡检的塔杆
	public int addTaskPole(PatrolFlawPojo pfp);
	//取消任务
	public int cancleTask(int p_id);
	//得到任务的巡检人员
	public List<PatrolUserPojo>getPtaskUser(int p_id);
	//更改任务状态
	public int updatePaskState(PatrolTaskPojo ptp);
	//更改任务详情
	public int updatePTask(PatrolTaskPojo ptp);
	//删除任务的分配人员
	public int deletePTaskUser(int p_id);
	//删除任务下巡检的塔杆
	public int deletePTaskFlaw(int p_id);
	//得到所有的执行回执任务
	public List<PatrolTaskPojo> getAllPTask(FuzzyPartPTaskParams fptp);
	//得到所有的执行回执任务
	public int getAllPTaskCount(FuzzyPartPTaskParams fptp);
	//更改任务执行时间
	public int updatePStartTime(PatrolTaskPojo ptp);
	//得到所有缺陷
	public List<FlawPojo> getPFlaw();
	//保存塔杆缺陷巡检信息
	public int updatePoleFlaw(PatrolFlawPojo pfp);
	//根据patrol_flaw的id查询
	public PatrolFlawPojo getOnePFP(int pf_id);
	//根据patrol_flaw的id查询 未定缺陷等级
	public PatrolFlawPojo getOnePFP2(int pf_id);
	//上传回执前检测
	public int uploadPTask (int p_id);
	//添加完成时间
	public int updatePFinishTime(PatrolTaskPojo ptp);
	//已完成的巡检任务
	public List<PatrolQueryPojo> getAllCompletePatrol(FuzzyPartPTaskParams fptp);
	//已完成的巡检任务总记录数
	public int getCompletePatrolCount(FuzzyPartPTaskParams fptp);
	//得到导出excel所需数据
	public List<PatrolQueryPojo> exportPatrolExcel();
	//巡检记录信息统计得到总记录数
	public int getPatrolInformationCount(InformationStatisticsParams isp);
	//巡检统计 得到相关记录
	public List<PatrolQueryPojo> getPatrolInformation(InformationStatisticsParams isp);
}
