package com.ysh.core.alimq.example.consumer;

/**
 * Copyright (C) 2010-2016 Alibaba Group Holding Limited
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.ysh.core.service.LogService;
import com.ysh.core.util.DateUtil;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * MQ消息处理类
 */
public class MessageListenerImpl implements MessageListener {

	@Autowired
	private LogService logService;

	@Override
	public Action consume(Message message, ConsumeContext consumeContext) {

		String logMessage = message.getBody().toString();
		String logId = message.getMsgID();
		System.out.println("consumer" + logId + "start date is :" + DateUtil.getDate());
		System.out.println(new Date() + " Receive message, Topic is:" + message.getTopic() + ", MsgId is:"
				+ message.getMsgID() + ", Msg is:" + message.getBody().toString());
		logService.saveLogMessage(logMessage, logId);
		System.out.println("consumer" + logId + "end date is :" + DateUtil.getDate());
		// 如果想测试消息重投的功能,可以将Action.CommitMessage 替换成Action.ReconsumeLater
		return Action.CommitMessage;
	}
}
