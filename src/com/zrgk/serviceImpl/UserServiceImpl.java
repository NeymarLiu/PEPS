package com.zrgk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.UserMapper;
import com.zrgk.pojo.UserPageParams;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.UserService;
import com.zrgk.util.PartPage;
/**
 * 
 * @author 龙汶宇
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public List<UserPojo> getAllUsers(UserPageParams upp) {
		// TODO Auto-generated method stub
		return userMapper.getAllUsers(upp);
	}

	@Override
	public int getCount(UserPageParams upp) {
		// TODO Auto-generated method stub
		return userMapper.getCount(upp);
	}
	public PartPage getPartPage(int count,int page) {
		PartPage p=new PartPage();
		int pages=0;
		if(count!=0){
			if (count%PartPage.pageSize!=0) {
				pages=count/PartPage.pageSize+1;
			}else {
				pages=count/PartPage.pageSize;
			}
			if(page<1){
				page=1;
			}else if (page>pages) {
				page=pages;
			}
			p.setCount(count);
			p.setNowPage(page);
			p.setTotalPage(pages);
		}else {
			p.setCount(0);
			p.setNowPage(1);
			p.setTotalPage(1);
		}
		return p;
	}
	@Override
	public UserPojo getUserById(int uid) {
		// TODO Auto-generated method stub
		return userMapper.getUserById( uid);
	}

	@Override
	public int addOneUser(UserPojo up) {
		// TODO Auto-generated method stub
		return userMapper.addOneUser(up);
	}

	@Override
	public int updateUser(UserPojo up) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(up);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(id);
	}

	@Override
	public int updateUserState(UserPojo up) {
		// TODO Auto-generated method stub
		return userMapper.updateUserState(up);
	}

	@Override
	public List<UserPojo> findAllUser() {
		// TODO Auto-generated method stub
		return userMapper.findAllUser();
	}

	@Override
	public int updateUserTime(int uid) {
		// TODO Auto-generated method stub
		return userMapper.updateUserTime(uid);
	}

}
