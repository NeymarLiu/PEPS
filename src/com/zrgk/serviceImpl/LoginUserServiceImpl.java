package com.zrgk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrgk.mapper.LoginUserMapper;
import com.zrgk.pojo.UserPojo;
import com.zrgk.service.LoginUserService;

@Service
public class LoginUserServiceImpl implements LoginUserService{
	//注入mapper层对象
	@Autowired
	private LoginUserMapper loginUserMapper;
	
	
	public LoginUserMapper getLoginUserMapper() {
		return loginUserMapper;
	}


	public void setLoginUserMapper(LoginUserMapper loginUserMapper) {
		this.loginUserMapper = loginUserMapper;
	}


	//登陆
	@Override
	public UserPojo login(UserPojo u) {
		// TODO Auto-generated method stub
		return loginUserMapper.login(u);
	}

}
