package com.zrgk.mapper;

import org.springframework.stereotype.Component;

import com.zrgk.pojo.UserPojo;

@Component
public interface LoginUserMapper {
    //登陆
	public UserPojo login(UserPojo u);
}
