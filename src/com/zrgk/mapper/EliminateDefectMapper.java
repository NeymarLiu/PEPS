package com.zrgk.mapper;

import java.util.List;

import com.zrgk.pojo.EdTaskPatrolFlowPojo;
import com.zrgk.pojo.EdTaskPojo;
import com.zrgk.pojo.EliminateDefectPojo;
import com.zrgk.pojo.EliminateDefectUserPojo;
import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.MoHuTask;
import com.zrgk.pojo.PatrolQueryPojo;
import com.zrgk.pojo.UserPojo;

public interface EliminateDefectMapper {
	//线路管理员的业务
	public List<EliminateDefectPojo> getAllEliminateDefect();//得到所有消缺任务
	public List<EliminateDefectPojo> getSomeEliminateDefect(MoHuTask mht);//模糊查询
	public int getAllTaskCount(MoHuTask mht);
	public String getMaxTaskId();//最大的id
	public List<UserPojo> getAllIssued();//所有的线路管理员（添加任务负责人）
	public List<UserPojo> getEliminateDefectPeople();
	public List<EdTaskPojo> selectAllFlaw();
	public int deleteTask(int e_id);
	public int freeTask(int e_id);
	//插入任务数据
	public int getIdByTask(EliminateDefectPojo edp);
	//得到名字
	public String getRealnameById(int u_realid);
	//添加人员
	public int addEdUser(EliminateDefectUserPojo edup);
	public int addEdTask(EliminateDefectPojo edp);
	public int addEdTaskPatrol(EdTaskPatrolFlowPojo epfp);
	public int updatePfState(EdTaskPatrolFlowPojo epfp);
	public int updateEdState(int id);
	public List<EdTaskPojo> selectTaskDetail(int id);
	public List<UserPojo> getTaskUser(int id);
	public int updateEdTask(EliminateDefectPojo edp);
	public int updateEdStateTwo(int id);
	public int addUpdateReceipt(EliminateDefectPojo edp);
	//=====================消缺员登录查询信息==========================
	public List<EliminateDefectPojo> getAllEliminateDefect2(UserPojo up);
	public List<EliminateDefectPojo> getSomeEliminateDefectTwo(MoHuTask mht);
	public int getAllTaskCount2(MoHuTask mht);
	public List<UserPojo> lookOneTaskUser(int id);
	public EliminateDefectPojo getAllValue(int id);
	public int updateEdStateThree(EliminateDefectPojo edp);
	public int getAllTaskCount3(MoHuTask mht);
	public List<FlawPojo> selectAllFlaw2();
	//========================遍历所有的任务======================
	public List<EdTaskPojo> getSomeEliminateDefect3(MoHuTask mht);
}
