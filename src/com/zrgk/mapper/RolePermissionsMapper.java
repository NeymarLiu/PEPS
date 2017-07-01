package com.zrgk.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zrgk.pojo.RolePermissionsPojo;

@Component
public interface RolePermissionsMapper {

	//给角色赋值权限
	public int toRoleSomePermissions(RolePermissionsPojo rpp);
	//删除 已赋值的权限
	public int deleteRoleMenu(int rid);
	//根据id得到相应的值
	public List<Integer> getRoleMenuById(int rid);
}
