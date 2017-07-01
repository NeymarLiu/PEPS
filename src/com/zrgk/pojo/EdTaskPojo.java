package com.zrgk.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EdTaskPojo {
	private int e_id;//消缺任务id
	private String e_task_id;//任务编号
	private String e_name;//任务名称
	private int e_security_id;//工作单据
	private String e_issued_name;//下发人
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
	private int pole_id;//塔杆id
	private String li_code;//线路编号
	private int pf_sure_grade;//缺陷确认等级
	private int pf_flaw;//缺陷类型id
	private String f_name;//缺陷名称
	private  String pf_find_people;//缺陷发现人姓名
	private Date pf_find_time;//发现时间
	private String find_time;//页面显示
	private String pf_remark;//缺陷备注
	private int pf_id;//塔杆缺陷id
	private String pole_code;//塔杆编号
	private int pf_flaw_rate;//完好率


	
	
	private int p_id;//巡检任务id
	private String p_num;//巡检任务编号
	private  String p_name;//巡检任务名称
	private int  p_state;//巡检业务状态
	private String p_strcode;//起始塔杆编号
	private String p_endcode;//终止塔杆编号
	private Date p_issued_time;//下发时间
	private String p_issued_name;//下发人姓名
	private int p_edstate;
	private int pf_flaw_grade;
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
	public Date getE_issued_time() {
		return e_issued_time;
	}
	public void setE_issued_time(Date e_issued_time) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		setIssued_time(sdf.format(e_issued_time));
		this.e_issued_time = e_issued_time;
	}
	public String getIssued_time() {
		return issued_time;
	}
	public void setIssued_time(String issued_time) {
		this.issued_time = issued_time;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setTask_finish_time(sdf.format(e_task_finish_time));
		this.e_task_finish_time = e_task_finish_time;
	}
	public String getTask_finish_time() {
		return task_finish_time;
	}
	public void setTask_finish_time(String task_finish_time) {
		this.task_finish_time = task_finish_time;
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
	public int getPole_id() {
		return pole_id;
	}
	public void setPole_id(int pole_id) {
		this.pole_id = pole_id;
	}
	public String getLi_code() {
		return li_code;
	}
	public void setLi_code(String li_code) {
		this.li_code = li_code;
	}
	public int getPf_sure_grade() {
		return pf_sure_grade;
	}
	public void setPf_sure_grade(int pf_sure_grade) {
		this.pf_sure_grade = pf_sure_grade;
	}
	public int getPf_flaw() {
		return pf_flaw;
	}
	public void setPf_flaw(int pf_flaw) {
		this.pf_flaw = pf_flaw;
	}
	
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getPf_find_people() {
		return pf_find_people;
	}
	public void setPf_find_people(String pf_find_people) {
		this.pf_find_people = pf_find_people;
	}
	public Date getPf_find_time() {
		return pf_find_time;
	}
	public void setPf_find_time(Date pf_find_time) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		setFind_time(sdf.format(pf_find_time));
		this.pf_find_time = pf_find_time;
	}
	
	public String getFind_time() {
		return find_time;
	}
	public void setFind_time(String find_time) {
		this.find_time = find_time;
	}
	public String getPf_remark() {
		return pf_remark;
	}
	public void setPf_remark(String pf_remark) {
		this.pf_remark = pf_remark;
	}
	public int getPf_id() {
		return pf_id;
	}
	public void setPf_id(int pf_id) {
		this.pf_id = pf_id;
	}
	public String getPole_code() {
		return pole_code;
	}
	public void setPole_code(String pole_code) {
		this.pole_code = pole_code;
	}
	public int getPf_flaw_rate() {
		return pf_flaw_rate;
	}
	public void setPf_flaw_rate(int pf_flaw_rate) {
		this.pf_flaw_rate = pf_flaw_rate;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
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
	public int getP_state() {
		return p_state;
	}
	public void setP_state(int p_state) {
		this.p_state = p_state;
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
	public Date getP_issued_time() {
		return p_issued_time;
	}
	public void setP_issued_time(Date p_issued_time) {
		this.p_issued_time = p_issued_time;
	}
	public String getP_issued_name() {
		return p_issued_name;
	}
	public void setP_issued_name(String p_issued_name) {
		this.p_issued_name = p_issued_name;
	}
	public int getP_edstate() {
		return p_edstate;
	}
	public void setP_edstate(int p_edstate) {
		this.p_edstate = p_edstate;
	}
	public int getPf_flaw_grade() {
		return pf_flaw_grade;
	}
	public void setPf_flaw_grade(int pf_flaw_grade) {
		this.pf_flaw_grade = pf_flaw_grade;
	}
	
	
}
