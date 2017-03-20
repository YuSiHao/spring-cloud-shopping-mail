package com.ysh.core.model;

public class JmsMessage {

	private String messageId;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	private String type;
	private String text;

	public JmsMessage() {

	}

	public JmsMessage(String type, String text) {
		this.type = type;
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "JmsMessage [type=" + type + ", text=" + text + ", messageId=" + messageId + "]";
	}

}
