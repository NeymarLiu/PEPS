package com.zrgk.util;

import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Encoder;



/**
 * 下载的工具类
 * @author 刘浩卿
 */
public class DownloadUtils {

	/**
	 * 进行BASE64Encoder编码
	 * @param fileName
	 * @return
	 */
	public static String base64EncodeFileName(String fileName) {
		
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?"
					+ new String(base64Encoder.encode(fileName
							.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
