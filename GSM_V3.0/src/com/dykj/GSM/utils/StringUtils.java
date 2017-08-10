package com.dykj.GSM.utils;

/**
* @author 作者 :wangmingyuan
* @version 创建时间：2016年6月21日 
* 修改人：
* 修改日期：
* 类说明: 字符串转化工具类
*/
public class StringUtils {

	public static void checkUsername(String username) {
		if ( null == username || username.trim().length() == 0) {
			throw new IllegalArgumentException("username must not be empty");
		}
		if (username.contains("\n") || username.contains("\r") || username.contains("\t")) {
			throw new IllegalArgumentException("username must not contain line feed character");
		}
		byte[] usernameByte = username.getBytes();
		if (usernameByte.length < 4 || usernameByte.length > 128) {
			throw new IllegalArgumentException("The length of username must between 4 and 128 bytes. Input is " + username);
		}
	}
	
	public static void checkPassword(String password) {
		if (null == password || password.trim().length() == 0) {
			throw new IllegalArgumentException("password must not be empty");
		}
		
		byte[] passwordByte = password.getBytes();
		if (passwordByte.length < 4 || passwordByte.length > 128) {
			throw new IllegalArgumentException("The length of password must between 4 and 128 bytes. Input is " + password);
		}
		
	}
	
	public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0;
    }
	
	public static boolean isTrimedEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
	
	public static boolean isLineBroken(String s) {
		if (s.contains("\n") || s.contains("\r")) {
			return true;
		}
		return false;
	}
	
}
