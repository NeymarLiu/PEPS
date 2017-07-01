package com.zrgk.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author liucan
 * @version 2016年11月25日11:12:35
 * */
public class MyDateConverter implements Converter<String,Date>{

	//准换器对象  作为准换器 就必须 要实现   准换器控制类接口  Converter
	@Override
	public Date convert(String str) {
		System.out.println("----日期转换器-----");
		if(str!="" && str!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date time=null;
			try {
				time = sdf.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return time;
		}else {
			return null;
		}
	}

	

}
