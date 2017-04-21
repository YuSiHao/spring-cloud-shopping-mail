package com.ysh.core.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ysh.core.util.json.IsoDateDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

@Document(collection = "logmessage")
public class LogMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty(value = "_id")
	private String logId;

	private String messsage;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS-hh:mm")
	@JsonDeserialize(using = IsoDateDeserializer.class)
	protected Date createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS-hh:mm")
	@JsonDeserialize(using = IsoDateDeserializer.class)
	protected Date modifiedDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getMesssage() {
		return messsage;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public String toString(LogMessage logMessage) {
		return logMessage.getLogId() + logMessage.getMesssage();
	}

}