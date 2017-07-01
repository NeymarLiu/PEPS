package com.zrgk.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liucan
 * @version 2016年11月23日12:24:04
 * */
public class PatrolFlawPojo implements Serializable{
	private int pf_id;//巡检缺陷id
	private int pf_pole;//塔杆id
	private int pf_flaw;//缺陷类别
	private int pf_flaw_grade;//缺陷等级
	private int pf_flaw_rate;//完成率
	private Date pf_find_time;//发现时间
	private String find_time;
	private String pf_find_people;//发现人姓名
	private String pf_remark;//备注
	private int p_id;//巡检任务id
	private int pf_state;//缺陷提交状态(0 保存 1 提交)
	private String pole_code;//塔杆编号
	private PatrolTaskPojo ptp;//巡检任务对象
	private PolePojo polePojo;//塔杆对象
	private String f_name;//缺陷名字
	private int pf_sure_grade;

	public int getPf_sure_grade() {
		return pf_sure_grade;
	}
	public void setPf_sure_grade(int pf_sure_grade) {
		this.pf_sure_grade = pf_sure_grade;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_name() {
		return f_name;
	}
	public void setPolePojo(PolePojo polePojo) {
		this.polePojo = polePojo;
	}
	public PolePojo getPolePojo() {
		return polePojo;
	}
	public void setFind_time(String find_time) {
		this.find_time = find_time;
	}
	public String getFind_time() {
		return find_time;
	}
	public void setPtp(PatrolTaskPojo ptp) {
		this.ptp = ptp;
	}
	public PatrolTaskPojo getPtp() {
		return ptp;
	}
	public void setPole_code(String pole_code) {
		this.pole_code = pole_code;
	}
	public String getPole_code() {
		return pole_code;
	}
	public int getPf_id() {
		return pf_id;
	}
	public void setPf_id(int pf_id) {
		this.pf_id = pf_id;
	}
	public int getPf_pole() {
		return pf_pole;
	}
	public void setPf_pole(int pf_pole) {
		this.pf_pole = pf_pole;
	}
	public int getPf_flaw() {
		return pf_flaw;
	}
	public void setPf_flaw(int pf_flaw) {
		this.pf_flaw = pf_flaw;
	}
	public int getPf_flaw_grade() {
		return pf_flaw_grade;
	}
	public void setPf_flaw_grade(int pf_flaw_grade) {
		this.pf_flaw_grade = pf_flaw_grade;
	}
	public int getPf_flaw_rate() {
		return pf_flaw_rate;
	}
	public void setPf_flaw_rate(int pf_flaw_rate) {
		this.pf_flaw_rate = pf_flaw_rate;
	}
	public Date getPf_find_time() {
		return pf_find_time;
	}
	public void setPf_find_time(Date pf_find_time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setFind_time(sdf.format(pf_find_time));
		this.pf_find_time = pf_find_time;
	}
	public String getPf_find_people() {
		return pf_find_people;
	}
	public void setPf_find_people(String pf_find_people) {
		this.pf_find_people = pf_find_people;
	}
	public String getPf_remark() {
		return pf_remark;
	}
	public void setPf_remark(String pf_remark) {
		this.pf_remark = pf_remark;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getPf_state() {
		return pf_state;
	}
	public void setPf_state(int pf_state) {
		this.pf_state = pf_state;
	}
	
}
