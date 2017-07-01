package com.zrgk.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zrgk.pojo.LogPageParams;
import com.zrgk.pojo.LogPojo;
/**
 * 
 * @author longwenyu
 *
 */
@Component
public interface LogMapper {

	//插入日志
	public int insertLog(LogPojo lp);
	//根据id得到所有的用户日志
	public List<LogPojo> getAllLogById(LogPageParams lpp);
	public int getCount(LogPageParams lpp);
}
