package com.zrgk.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author liucan
 * @version 2016年11月23日12:24:04
 * */
public class PatrolTaskPojo implements Serializable{
	private int p_id;//巡检任务id
	private String p_num;//巡检任务编号
	private String p_name;//巡检线路名称
	private int p_lid;//巡检线路编号
	private int p_strnum;//起始杆号
	private int p_endnum;//终止杆号
	private String p_issued_name;//下发人姓名
	private int p_issued_id;//下发人id
	private Date p_issued_time;//下发时间
	private Date p_start_time;//巡检开始时间
	private String start_time;//下发时间
	private String issued_time;//下发时间(页面显示)
	private int p_state;//巡检任务状态
	private String p_remark;//备注
	private int p_edstate;//消缺任务状态
	private Date p_finish_time;//完成时间
	private String finish_time;//完成时间
	private PolePojo strPojo;//起始塔杆对象
	private PolePojo endPojo;//终止塔杆对象
	private LinePojo line;//线路对象
	private List<PatrolUserPojo> pupList;//线路对应的巡检员集合
	private List<PatrolFlawPojo> pfpList;//线路对应的塔杆的集合
	public void setP_issued_id(int p_issued_id) {
		this.p_issued_id = p_issued_id;
	}
	public int getP_issued_id() {
		return p_issued_id;
	}
	public void setPfpList(List<PatrolFlawPojo> pfpList) {
		this.pfpList = pfpList;
	}
	public List<PatrolFlawPojo> getPfpList() {
		return pfpList;
	}
	public void setPupList(List<PatrolUserPojo> pupList) {
		this.pupList = pupList;
	}
	public List<PatrolUserPojo> getPupList() {
		return pupList;
	}
	public void setP_finish_time(Date p_finish_time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setFinish_time(sdf.format(p_finish_time));
		this.p_finish_time = p_finish_time;
	}
	public Date getP_finish_time() {
		return p_finish_time;
	}
	public LinePojo getLine() {
		return line;
	}
	public void setLine(LinePojo line) {
		this.line = line;
	}
	public void setEndPojo(PolePojo endPojo) {
		this.endPojo = endPojo;
	}
	
	public PolePojo getStrPojo() {
		return strPojo;
	}

	public void setStrPojo(PolePojo strPojo) {
		this.strPojo = strPojo;
	}

	public PolePojo getEndPojo() {
		return endPojo;
	}
	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}
	public String getIssued_time() {
		return issued_time;
	}
	public void setIssued_time(String issued_time) {
		this.issued_time = issued_time;
	}
	public String getFinish_time() {
		return finish_time;
	}
	public void setP_edstate(int p_edstate) {
		this.p_edstate = p_edstate;
	}
	public int getP_edstate() {
		return p_edstate;
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
	public void setP_lid(int p_lid) {
		this.p_lid = p_lid;
	}
	public int getP_lid() {
		return p_lid;
	}
	public int getP_strnum() {
		return p_strnum;
	}
	public void setP_strnum(int p_strnum) {
		this.p_strnum = p_strnum;
	}
	public int getP_endnum() {
		return p_endnum;
	}
	public void setP_endnum(int p_endnum) {
		this.p_endnum = p_endnum;
	}
	public String getP_issued_name() {
		return p_issued_name;
	}
	public void setP_issued_name(String p_issued_name) {
		this.p_issued_name = p_issued_name;
	}
	public Date getP_issued_time() {
		return p_issued_time;
	}
	public void setP_issued_time(Date p_issued_time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setIssued_time(sdf.format(p_issued_time));
		this.p_issued_time = p_issued_time;
	}
	public int getP_state() {
		return p_state;
	}
	public void setP_state(int p_state) {
		this.p_state = p_state;
	}
	public String getP_remark() {
		return p_remark;
	}
	public void setP_remark(String p_remark) {
		this.p_remark = p_remark;
	}
	public Date getP_start_time() {
		return p_start_time;
	}
	public void setP_start_time(Date p_start_time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setStart_time(sdf.format(p_start_time));
		this.p_start_time = p_start_time;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	
}
