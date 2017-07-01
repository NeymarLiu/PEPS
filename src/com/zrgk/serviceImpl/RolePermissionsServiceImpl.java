package com.zrgk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.RolePermissionsMapper;
import com.zrgk.pojo.RolePermissionsPojo;
import com.zrgk.service.RolePermissionsService;

@Service
public class RolePermissionsServiceImpl implements RolePermissionsService {

	@Autowired
	private RolePermissionsMapper rolePermissionsMapper;

	public RolePermissionsMapper getRolePermissionsMapper() {
		return rolePermissionsMapper;
	}

	public void setRolePermissionsMapper(RolePermissionsMapper rolePermissionsMapper) {
		this.rolePermissionsMapper = rolePermissionsMapper;
	}

	@Override
	public int toRoleSomePermissions( RolePermissionsPojo rpp) {
		// TODO Auto-generated method stub
		return rolePermissionsMapper.toRoleSomePermissions( rpp);
	}

	@Override
	public int deleteRoleMenu(int rid) {
		// TODO Auto-generated method stub
		return rolePermissionsMapper.deleteRoleMenu(rid);
	}

	@Override
	public List<Integer> getRoleMenuById(int rid) {
		// TODO Auto-generated method stub
		return rolePermissionsMapper.getRoleMenuById(rid);
	}
	
}
