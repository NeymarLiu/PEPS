package com.zrgk.service;

import java.util.List;

import com.zrgk.pojo.MenuPageParams;
import com.zrgk.pojo.MenuPojo;
import com.zrgk.pojo.RolePageParams;
import com.zrgk.pojo.RolePojo;
import com.zrgk.util.PartPage;
/**
 * 
 * @author 龙汶宇
 *
 */
public interface RoleService {


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
	public PartPage getPartPage(int count,int page);
	//修改角色下面的用户
	public int updateUserRole(RolePojo rp);
}
