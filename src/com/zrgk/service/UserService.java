package com.zrgk.service;

import java.util.List;

import com.zrgk.pojo.UserPageParams;
import com.zrgk.pojo.UserPojo;
import com.zrgk.util.PartPage;
/**
 * 
 * @author 龙汶宇
 *
 */
public interface UserService {

	//得到所有的用户并且分页
	public List<UserPojo> getAllUsers(UserPageParams rpp);
	
	public int getCount(UserPageParams rpp);
	
	public PartPage getPartPage(int count,int page);
	//通过id得到用户信息
	public UserPojo getUserById(int uid);
	//插入用户信息
	public int addOneUser(UserPojo up);
	//通过id修改用户信息
	public int updateUser(UserPojo up);
	//根据id删除用户信息
	public int deleteUser(int id);
	//通过id 修改用户的状态
	public int updateUserState(UserPojo up);
	//得到所有的用户
	public List<UserPojo> findAllUser();
	//根据id修改用户时间
	public int updateUserTime(int uid);
}
