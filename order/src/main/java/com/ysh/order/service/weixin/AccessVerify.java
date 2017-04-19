package com.ysh.order.service.weixin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.ysh.order.constant.BaseConst;


@Service("accessVerify")
public final class AccessVerify {
	
	public String excuteVerify(String signature, String timestamp, String nonce, String echostr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return isSafe(signature, timestamp, nonce) ? echostr : "Drop";
	}
	
	private boolean isSafe(String signature, String timestamp, String nonce) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return signature.equals(this.genSecueSignature(BaseConst.WEIXIN_CUSTOM_TOKEN, timestamp, nonce));
	}
	
	private String genSecueSignature(String... strings) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Arrays.sort(strings);
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(strings).forEach((String string)->{stringBuilder.append(string);});
		messageDigest.update(stringBuilder.toString().getBytes());
		return this.getHexString(messageDigest.digest());
	}
	
	private String getHexString(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			hexString.append(Integer.toHexString(bytes[i] & 0xFF));
		}
		return hexString.toString();
	}
	
}
