package com.zrgk.service;

import java.util.List;

import com.zrgk.pojo.RolePermissionsPojo;

public interface RolePermissionsService {

	//给角色赋值权限
	public int toRoleSomePermissions(RolePermissionsPojo rpp);
	//删除 已赋值的权限
	public int deleteRoleMenu(int rid);
	//根据id得到相应的值
	public List<Integer> getRoleMenuById(int rid);
}
