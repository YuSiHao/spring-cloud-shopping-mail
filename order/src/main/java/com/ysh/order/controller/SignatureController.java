package com.ysh.order.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysh.order.model.Message;
import com.ysh.order.service.weixin.AccessVerify;
import com.ysh.order.util.DataUtil;


@RestController
@RequestMapping(value = "/talk")
public class SignatureController {

	private static final Logger logger = LogManager.getLogger(SignatureController.class);
	
	@Autowired
	private AccessVerify accessVerify;
	
	@RequestMapping(value = "/", produces = "text/html; charset=utf-8", method = RequestMethod.GET)
	public String verifySignature(
			@RequestParam(defaultValue = "") String signature,
			@RequestParam(defaultValue = "") String timestamp,
			@RequestParam(defaultValue = "") String nonce,
			@RequestParam(defaultValue = "") String echostr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		logger.info("Verify Signature {} {} {} {}", signature, timestamp, nonce, echostr);
		return accessVerify.excuteVerify(signature, timestamp, nonce, echostr);
	}
	
	@RequestMapping(value = "/", produces = "application/xml; charset=utf-8", method = RequestMethod.POST)
	public Message getMessage(@RequestBody Message getMessage) {
		logger.info("Get message from WeiXin {}", getMessage.getFromUserName());
		// getMessage.getFromUserName() is WeiXin openId
		Message sendMessage = new Message();
		sendMessage.setFromUserName(getMessage.getToUserName());
		sendMessage.setToUserName(getMessage.getFromUserName());
		sendMessage.setCreateTime(DataUtil.getEpochHour());
		sendMessage.setMsgType("text");
		sendMessage.setContent("welcome" + getMessage.getFromUserName());
		return sendMessage;
	}
	
}
