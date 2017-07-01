package com.zrgk.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author longwenyu
 *  2016-11-23
 */
public class UserPojo implements Serializable{

	private int u_id;
	private String u_loginname;
	private String u_password;
	private int u_sex;
	private int u_age;
	private String u_email;
	private String u_phone;
	private Date u_intime;
	private String p_u_intime;//页面显示时间
	private Date u_outtime;
	private String p_u_outtime;//页面显示时间
	private int u_state;
	private int u_selete;
	private Date u_logintime;
	private String p_u_logintime;//页面显示时间
	private int r_id;
	private String u_realname;
	private RolePojo rolePojo;
	private String u_repassword;
	public void setU_repassword(String u_repassword) {
		this.u_repassword = u_repassword;
	}
	public String getU_repassword() {
		return u_repassword;
	}
	public String getP_u_intime() {
		return p_u_intime;
	}
	public void setP_u_intime(String p_u_intime) {
		this.p_u_intime = p_u_intime;
	}
	public String getP_u_outtime() {
		return p_u_outtime;
	}
	public void setP_u_outtime(String p_u_outtime) {
		this.p_u_outtime = p_u_outtime;
	}
	public String getP_u_logintime() {
		return p_u_logintime;
	}
	public void setP_u_logintime(String p_u_logintime) {
		this.p_u_logintime = p_u_logintime;
	}
	public RolePojo getRolePojo() {
		return rolePojo;
	}
	public void setRolePojo(RolePojo rolePojo) {
		this.rolePojo = rolePojo;
	}
	public Date getU_logintime() {
		return u_logintime;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_loginname() {
		return u_loginname;
	}
	public void setU_loginname(String u_loginname) {
		this.u_loginname = u_loginname;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public int getU_sex() {
		return u_sex;
	}
	public void setU_sex(int u_sex) {
		this.u_sex = u_sex;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int u_age) {
		this.u_age = u_age;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public Date getU_intime() {
		return u_intime;
	}
	public void setU_intime(Date u_intime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(u_intime != null ){
			setP_u_intime(sdf.format(u_intime));
		}
		
		this.u_intime = u_intime;
	}
	public Date getU_outtime() {
		return u_outtime;
	}
	public void setU_outtime(Date u_outtime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(u_outtime != null){
			setP_u_outtime(sdf.format(u_outtime));
		}		
		this.u_outtime = u_outtime;
	}
	public int getU_state() {
		return u_state;
	}
	public int getU_selete() {
		return u_selete;
	}
	public void setU_selete(int u_selete) {
		this.u_selete = u_selete;
	}
	public void setU_state(int u_state) {
		this.u_state = u_state;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getU_realname() {
		return u_realname;
	}
	public void setU_realname(String u_realname) {
		this.u_realname = u_realname;
	}
	public void setU_logintime(Date u_logintime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		setP_u_logintime(sdf.format(u_logintime));
		this.u_logintime = u_logintime;
	}
}
