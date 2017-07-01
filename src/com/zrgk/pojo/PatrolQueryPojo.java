package com.zrgk.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author liucan
 * @version 2016年12月2日13:41:21
 * @用途  巡检查询功能
 * */
public class PatrolQueryPojo {
	private int pf_id;//塔杆缺陷id
	private int p_id;//巡检任务id
	private String p_num;//巡检任务编号
	private int pole_id;//塔杆id
	private String pole_code;//塔杆编号
	private int pf_sure_grade;//确认等级
	private  String p_name;//巡检任务名称
	private  String pf_find_people;//缺陷发现人姓名
	private Date pf_find_time;//发现时间
	private String find_time;//页面显示
	private int  p_state;//巡检业务状态
	private String p_strcode;//起始塔杆编号
	private String p_endcode;//终止塔杆编号
	private String li_code;//线路编号
	private Date p_issued_time;//下发时间
	private String issued_time;
	private String p_issued_name;//下发人姓名
	private String pf_remark;//缺陷备注
	private int pf_flaw;//缺陷类型
	private int p_edstate;
	private int pf_flaw_grade;
	public void setPf_flaw_grade(int pf_flaw_grade) {
		this.pf_flaw_grade = pf_flaw_grade;
	}
	public int getPf_flaw_grade() {
		return pf_flaw_grade;
	}
	public void setP_edstate(int p_edstate) {
		this.p_edstate = p_edstate;
	}
	public int getP_edstate() {
		return p_edstate;
	}
	public void setPf_id(int pf_id) {
		this.pf_id = pf_id;
	}
	public int getPf_id() {
		return pf_id;
	}
	public void setPf_flaw(int pf_flaw) {
		this.pf_flaw = pf_flaw;
	}
	public int getPf_flaw() {
		return pf_flaw;
	}
	public Date getPf_find_time() {
		return pf_find_time;
	}
	public void setPf_find_time(Date pf_find_time) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		setFind_time(sdf.format(pf_find_time));
		this.pf_find_time = pf_find_time;
	}
	public void setPf_remark(String pf_remark) {
		this.pf_remark = pf_remark;
	}
	public String getPf_remark() {
		return pf_remark;
	}
	private int pf_flaw_rate;
	public void setPf_flaw_rate(int pf_flaw_rate) {
		this.pf_flaw_rate = pf_flaw_rate;
	}
	public int getPf_flaw_rate() {
		return pf_flaw_rate;
	}
	public Date getP_issued_time() {
		return p_issued_time;
	}
	public void setP_issued_time(Date p_issued_time) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		setIssued_time(sdf.format(p_issued_time));
		this.p_issued_time = p_issued_time;
	}
	public String getIssued_time() {
		return issued_time;
	}
	public void setIssued_time(String issued_time) {
		this.issued_time = issued_time;
	}
	public String getP_issued_name() {
		return p_issued_name;
	}
	public void setP_issued_name(String p_issued_name) {
		this.p_issued_name = p_issued_name;
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
	public int getPole_id() {
		return pole_id;
	}
	public void setPole_id(int pole_id) {
		this.pole_id = pole_id;
	}
	public String getPole_code() {
		return pole_code;
	}
	public void setPole_code(String pole_code) {
		this.pole_code = pole_code;
	}
	public int getPf_sure_grade() {
		return pf_sure_grade;
	}
	public void setPf_sure_grade(int pf_sure_grade) {
		this.pf_sure_grade = pf_sure_grade;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public void setPf_find_people(String pf_find_people) {
		this.pf_find_people = pf_find_people;
	}
	public String getPf_find_people() {
		return pf_find_people;
	}
	public Date getP_find_time() {
		return pf_find_time;
	}
	public String getFind_time() {
		return find_time;
	}
	public void setFind_time(String find_time) {
		this.find_time = find_time;
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
	public String getLi_code() {
		return li_code;
	}
	public void setLi_code(String li_code) {
		this.li_code = li_code;
	}
	
	
	
}
