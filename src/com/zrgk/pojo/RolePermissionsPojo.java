package com.zrgk.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author longwenyu
 *
 */
public class RolePermissionsPojo implements Serializable{

	//角色菜单的中间表
	private int r_id;
	private int m_id;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	
}
