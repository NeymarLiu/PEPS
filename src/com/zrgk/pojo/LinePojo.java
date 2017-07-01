package com.zrgk.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LinePojo implements Serializable{
	
	private int li_id;   //线路id
	private String  li_code;  //线路编号
	private String  li_name;  //线路名称
	private String  li_beginpole; //开始塔杆
	private String  li_endpole;  //结束塔杆
    private int li_backlength;  //回路长度
    private Date li_totime;  //投运时间
    private String totime;
    public String getTotime() {
		return totime;
	}
	public void setTotime(String totime) {
		this.totime = totime;
	}
	private int li_presslevel;  //电压等级
    private int li_count;  //塔基数
    private int li_state;  //线路启用状
    private int li_run;  //线路运行状
    private String li_dess; //备注
	public int getLi_id() {
		return li_id;
	}
	public void setLi_id(int li_id) {
		this.li_id = li_id;
	}
	public String getLi_code() {
		return li_code;
	}
	public void setLi_code(String li_code) {
		this.li_code = li_code;
	}
	public String getLi_name() {
		return li_name;
	}
	public void setLi_name(String li_name) {
		this.li_name = li_name;
	}
	public String getLi_beginpole() {
		return li_beginpole;
	}
	public void setLi_beginpole(String li_beginpole) {
		this.li_beginpole = li_beginpole;
	}
	public String getLi_endpole() {
		return li_endpole;
	}
	public void setLi_endpole(String li_endpole) {
		this.li_endpole = li_endpole;
	}
	public int getLi_backlength() {
		return li_backlength;
	}
	public void setLi_backlength(int li_backlength) {
		this.li_backlength = li_backlength;
	}
	public Date getLi_totime() {
		return li_totime;
	}
	public void setLi_totime(Date li_totime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setTotime(sdf.format(li_totime));
		this.li_totime = li_totime;
	}
	public int getLi_presslevel() {
		return li_presslevel;
	}
	public void setLi_presslevel(int li_presslevel) {
		this.li_presslevel = li_presslevel;
	}
	public int getLi_count() {
		return li_count;
	}
	public void setLi_count(int li_count) {
		this.li_count = li_count;
	}
	public int getLi_state() {
		return li_state;
	}
	public void setLi_state(int li_state) {
		this.li_state = li_state;
	}
	public int getLi_run() {
		return li_run;
	}
	public void setLi_run(int li_run) {
		this.li_run = li_run;
	}
	public String getLi_dess() {
		return li_dess;
	}
	public void setLi_dess(String li_dess) {
		this.li_dess = li_dess;
	}
	public LinePojo() {
		super();
	}
    
	
    

}
