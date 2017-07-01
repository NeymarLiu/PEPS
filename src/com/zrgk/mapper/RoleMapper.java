package com.zrgk.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zrgk.pojo.RolePageParams;
import com.zrgk.pojo.RolePojo;
/**
 * 
 * @author 龙汶宇
 *
 */
@Component
public interface RoleMapper {

	
	//得到所有的角色并且分页
	public List<RolePojo> getAllRoles(RolePageParams rpp);
	//得到所有的角色
	public List<RolePojo> findAllRoles();
	//得到所有的角色
	public List<RolePojo> findAllRoles2();
	//得到所有的角色
	public List<RolePojo> findAllRoles3();
	//通过id 得到角色的信息
	public RolePojo getRoleById(int id);
	//得到总记录数
	public int getCount(RolePageParams rpp);
	//根据id删除角色
	public int deleteRole(int id);
	//添加角色信息
	public int addRole(RolePojo rp);
	//更具id修改角色
	public int updateRole(RolePojo rp);
	//修改角色下面的用户
	public int updateUserRole(RolePojo rp);
}
