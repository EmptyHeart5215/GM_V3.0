package com.dykj.GSM.utils;

import java.security.SecureRandom;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import net.sf.json.JSONObject;

import org.springframework.security.core.context.SecurityContextHolder;

import com.dykj.GSM.model.SessionModel;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MySession {
	public static ThreadLocal<SessionModel> Info = new ThreadLocal<SessionModel>();
	public static SessionModel session;

	@SuppressWarnings("unchecked")
	public static boolean setInfo(String DesString) throws Exception {
		try {
			byte[] tempOld = hexStringToBytes(DesString);
			byte[] temp = decrypt(tempOld);
			String tempString = new String(temp);
			ObjectMapper mapper = new ObjectMapper();
			Info.set(mapper.readValue(new String(tempString), SessionModel.class));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static Map<String, Object> getUkey(String DesString) throws Exception {
		byte[] tempOld = hexStringToBytes(DesString);
		byte[] temp = decrypt(tempOld);
		String tempString = new String(temp);
		return JSONObject.fromObject(tempString);
	}

	public static void setInfo(SessionModel data) throws Exception {
		Info.set(data);
	}

	public static SessionModel getInfo() {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			return Info.get();
		}
		SessionModel model = (SessionModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return model;
	}

	public static String getInfoDesString(SessionModel session) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		byte[] tempOld = mapper.writeValueAsString(session).getBytes();
		byte[] temp = desCrypto(tempOld);
		String tempString = bytesToHexString(temp);
		return tempString;
	}

	private static String password = "zhangaaa";

	/**
	 * 加密
	 * 
	 * @param datasource
	 * @param password
	 * @return
	 */
	private static byte[] desCrypto(byte[] datasource) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param src
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] src) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * Convert hex string to byte[]
	 * 
	 * @param hexString
	 *            the hex string
	 * @return byte[]
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	/**
	 * Convert char to byte
	 * 
	 * @param c
	 *            char
	 * @return byte
	 */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
}
