package com.ysh.order.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "xml")
public class Message {

	@JacksonXmlProperty(localName = "ToUserName")
	@JacksonXmlCData
	private String toUserName;

	@JacksonXmlProperty(localName = "FromUserName")
	@JacksonXmlCData
	private String fromUserName;

	@JacksonXmlProperty(localName = "CreateTime")
	private Long createTime;

	@JacksonXmlProperty(localName = "MsgType")
	@JacksonXmlCData
	private String msgType;

	@JacksonXmlProperty(localName = "Content")
	@JacksonXmlCData
	private String content;

	@JacksonXmlProperty(localName = "MsgId")
	private Long msgId;

	@JacksonXmlProperty(localName = "PicUrl")
	@JacksonXmlCData
	private String picUrl;

	@JacksonXmlProperty(localName = "MediaId")
	@JacksonXmlCData
	private String mediaId;

	@JacksonXmlProperty(localName = "Format")
	@JacksonXmlCData
	private String format;

	@JacksonXmlProperty(localName = "ThumbMediaId")
	@JacksonXmlCData
	private String thumbMediaId;

	@JacksonXmlProperty(localName = "Location_X")
	private Double locationX;

	@JacksonXmlProperty(localName = "Location_Y")
	private Double locationY;

	@JacksonXmlProperty(localName = "Scale")
	private Double scale;

	@JacksonXmlProperty(localName = "Label")
	@JacksonXmlCData
	private String label;

	@JacksonXmlProperty(localName = "Title")
	@JacksonXmlCData
	private String title;

	@JacksonXmlProperty(localName = "Description")
	@JacksonXmlCData
	private String description;

	@JacksonXmlProperty(localName = "Url")
	@JacksonXmlCData
	private String url;

	@JacksonXmlProperty(localName = "Event")
	@JacksonXmlCData
	private String event;

	@JacksonXmlProperty(localName = "EventKey")
	@JacksonXmlCData
	private String eventKey;

	@JacksonXmlProperty(localName = "Ticket")
	@JacksonXmlCData
	private String ticket;

	@JacksonXmlProperty(localName = "Latitude")
	private Double latitude;

	@JacksonXmlProperty(localName = "Longitude")
	private Double longitude;

	@JacksonXmlProperty(localName = "Precision")
	private Double precision;

	@JacksonXmlProperty(localName = "Recognition")
	@JacksonXmlCData
	private String recognition;

	public String getToUserName() {
		return toUserName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public Double getLocationX() {
		return locationX;
	}

	public void setLocationX(Double locationX) {
		this.locationX = locationX;
	}

	public Double getLocationY() {
		return locationY;
	}

	public void setLocationY(Double locationY) {
		this.locationY = locationY;
	}

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getPrecision() {
		return precision;
	}

	public void setPrecision(Double precision) {
		this.precision = precision;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

}
