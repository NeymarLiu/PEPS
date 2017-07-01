package com.zrgk.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTaskPojo {
	private int p_id;//巡检任务id
	private int u_id;//用户名
	private String p_num;//巡检任务编号
	private String p_name;//巡检任务名称
	private String li_name;//线路名称
	private String p_remark;//备注
	private String p_strcode;//起始杆号
	private String p_endcode;//终止杆号
	private String p_issued_name;//下发人姓名
	private Date p_issued_time;//下发时间
	private String issude_time;//下发时间页面显示的时间
	private Date p_finish_time;//完成任务时间
	private String finish_time;//完成任务时间 页面显示的时间
	private int p_state;//巡检任务状态
	private int p_edstate;//消缺任务状态
	private String getOne;//查看的链接
	private String toOne;//处理的链接
	private String taskName;
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setToOne(String toOne) {
		this.toOne = toOne;
	}
	public String getToOne() {
		return toOne;
	}
	public void setGetOne(String getOne) {
		this.getOne = getOne;
	}
	public String getGetOne() {
		return getOne;
	}
	public void setP_edstate(int p_edstate) {
		this.p_edstate = p_edstate;
	}
	public int getP_edstate() {
		return p_edstate;
	}
	public Date getP_issued_time() {
		return p_issued_time;
	}
	public void setP_issued_time(Date p_issued_time) {
		//日期格式转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setIssude_time(sdf.format(p_issued_time));
		this.p_issued_time = p_issued_time;
	}
	public String getIssude_time() {
		return issude_time;
	}
	public void setIssude_time(String issude_time) {
		this.issude_time = issude_time;
	}
	public Date getP_finish_time() {
		return p_finish_time;
	}
	public void setP_finish_time(Date p_finish_time) {
		//日期转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setFinish_time(sdf.format(p_finish_time));
		this.p_finish_time = p_finish_time;
	}
	public String getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getLi_name() {
		return li_name;
	}
	public void setLi_name(String li_name) {
		this.li_name = li_name;
	}
	public String getP_remark() {
		return p_remark;
	}
	public void setP_remark(String p_remark) {
		this.p_remark = p_remark;
	}
	public String getP_strcode() {
		return p_strcode;
	}
	public void setP_strcode(String p_strcode) {
		this.p_strcode = p_strcode;
	}
	public String getP_endcode() {
		return p_endcode;
	}
	public void setP_endcode(String p_endcode) {
		this.p_endcode = p_endcode;
	}
	public String getP_issued_name() {
		return p_issued_name;
	}
	public void setP_issued_name(String p_issued_name) {
		this.p_issued_name = p_issued_name;
	}
	public int getP_state() {
		return p_state;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public void setP_state(int p_state) {
		this.p_state = p_state;
	}
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	
	
	
}
