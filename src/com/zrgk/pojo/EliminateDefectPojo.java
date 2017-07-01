package com.zrgk.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EliminateDefectPojo {

	private int e_id;//消缺任务id
	private String e_task_id;//任务编号
	private String e_name;//任务名称
	private int e_security_id;//工作单据
	private String e_issued_name;//下发人
	private int e_issued_id;//下发人id
	private Date e_issued_time;//下发时间
	private String issued_time;//页面显示下发时间
	private int e_task_state;//任务状态（1、待分配，2、已分配，3、执行中，4、已完成）
	private Date e_task_finish_time;//任务完成时间
	private String task_finish_time;//页面显示任务完成时间
	private int e_task_cancel_state;//任务是否取消（1、是，2、否）
	private String e_task_described;//任务描述
	private String e_remark;//任务备注
	private String e_task_principal;//任务负责人
	private String e_final_described;//任务完成描述
	
	private List<UserPojo> upList;//消缺员对象集合
	private EliminateDefectUserPojo edup;//用户任务中间表对象
	private UserPojo user;//用户对象
	private PatrolFlawPojo pfpList;//缺陷对象集合
	public String getIssued_time() {
		return issued_time;
	}
	public void setIssued_time(String issued_time) {
		this.issued_time = issued_time;
	}
	public String getTask_finish_time() {
		return task_finish_time;
	}
	public void setTask_finish_time(String task_finish_time) {
		this.task_finish_time = task_finish_time;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getE_task_id() {
		return e_task_id;
	}
	public void setE_task_id(String e_task_id) {
		this.e_task_id = e_task_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public int getE_security_id() {
		return e_security_id;
	}
	public void setE_security_id(int e_security_id) {
		this.e_security_id = e_security_id;
	}
	public String getE_issued_name() {
		return e_issued_name;
	}
	public void setE_issued_name(String e_issued_name) {
		this.e_issued_name = e_issued_name;
	}
	
	public int getE_issued_id() {
		return e_issued_id;
	}
	public void setE_issued_id(int e_issued_id) {
		this.e_issued_id = e_issued_id;
	}
	public Date getE_issued_time() {
		return e_issued_time;
	}
	public void setE_issued_time(Date e_issued_time) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		setIssued_time(sdf.format(e_issued_time));
		this.e_issued_time = e_issued_time;
	}
	public int getE_task_state() {
		return e_task_state;
	}
	public void setE_task_state(int e_task_state) {
		this.e_task_state = e_task_state;
	}
	public Date getE_task_finish_time() {
		return e_task_finish_time;
	}
	public void setE_task_finish_time(Date e_task_finish_time) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		setTask_finish_time(sdf.format(e_task_finish_time));
		this.e_task_finish_time = e_task_finish_time;
	}
	public int getE_task_cancel_state() {
		return e_task_cancel_state;
	}
	public void setE_task_cancel_state(int e_task_cancel_state) {
		this.e_task_cancel_state = e_task_cancel_state;
	}
	public String getE_task_described() {
		return e_task_described;
	}
	public void setE_task_described(String e_task_described) {
		this.e_task_described = e_task_described;
	}
	public String getE_remark() {
		return e_remark;
	}
	public void setE_remark(String e_remark) {
		this.e_remark = e_remark;
	}
	public String getE_task_principal() {
		return e_task_principal;
	}
	public void setE_task_principal(String e_task_principal) {
		this.e_task_principal = e_task_principal;
	}
	
	
	public String getE_final_described() {
		return e_final_described;
	}
	public void setE_final_described(String e_final_described) {
		this.e_final_described = e_final_described;
	}
	public EliminateDefectUserPojo getEdup() {
		return edup;
	}
	public void setEdup(EliminateDefectUserPojo edup) {
		this.edup = edup;
	}
	public List<UserPojo> getUpList() {
		return upList;
	}
	public void setUpList(List<UserPojo> upList) {
		this.upList = upList;
	}
	public UserPojo getUser() {
		return user;
	}
	public void setUser(UserPojo user) {
		this.user = user;
	}
	public PatrolFlawPojo getPfpList() {
		return pfpList;
	}
	public void setPfpList(PatrolFlawPojo pfpList) {
		this.pfpList = pfpList;
	}
	
}
