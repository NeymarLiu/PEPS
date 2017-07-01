package com.zrgk.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgk.pojo.EdTaskPatrolFlowPojo;
import com.zrgk.pojo.EdTaskPojo;
import com.zrgk.pojo.EliminateDefectPojo;
import com.zrgk.pojo.EliminateDefectUserPojo;
import com.zrgk.pojo.FlawPojo;
import com.zrgk.pojo.MoHuTask;
import com.zrgk.pojo.PatrolQueryPojo;
import com.zrgk.pojo.UserPojo;
import com.zrgk.util.PartPage;

public interface EliminateDefectService {

	public List<EliminateDefectPojo> getAllEliminateDefect();
	public List<EliminateDefectPojo> getSomeEliminateDefect(MoHuTask mht);
	public int getAllTaskCount(MoHuTask mht);
	//分页
	public PartPage getPartPage(int count,int page);
	public String getMaxTaskId();
	public List<UserPojo> getAllIssued();//所有的线路管理员（添加任务负责人）
	public List<UserPojo> getEliminateDefectPeople();
	public List<EdTaskPojo> selectAllFlaw();
	//添加任务
	public int addEdTask(EliminateDefectPojo edp);
	public int getIdByTask(EliminateDefectPojo edp);
	public String getRealnameById(int u_realid);
	public int addEdUser(EliminateDefectUserPojo edup);
	public int addEdTaskPatrol(EdTaskPatrolFlowPojo epfp);
	public int updatePfState(EdTaskPatrolFlowPojo epfp);
	public List<EdTaskPojo> selectTaskDetail(int id);
	public List<UserPojo> getTaskUser(int id);
	public int updateEdTask(EliminateDefectPojo edp);
	public int updateEdStateTwo(int id);
	public int freeTask(int e_id);
	//删除任务
	public int deleteTask(int e_id);
	public int updateEdState(int id);
	
	//======================消缺员登录查询信息================================
	public List<EliminateDefectPojo> getAllEliminateDefect2(UserPojo up);
	public List<EliminateDefectPojo> getSomeEliminateDefectTwo(MoHuTask mht);
	public int getAllTaskCount2(MoHuTask mht);
	public List<UserPojo> lookOneTaskUser(int id);
	public EliminateDefectPojo getAllValue(int id);
	public int addUpdateReceipt(EliminateDefectPojo edp);
	public int updateEdStateThree(EliminateDefectPojo edp);
	public int getAllTaskCount3(MoHuTask mht);
	public List<FlawPojo> selectAllFlaw2();
	public List<EdTaskPojo> getSomeEliminateDefect3(MoHuTask mht);
	public void export(HttpServletRequest request,
			HttpServletResponse response,List<EdTaskPojo> list)
			throws ServletException, IOException ;
	//=============信息统计================
	public void exportT(HttpServletRequest request,
			HttpServletResponse response,List<EdTaskPojo> list)
			throws ServletException, IOException ;
}
