package com.ysh.core.util.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class IsoDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();//get the objectCode 
		JsonNode node = oc.readTree(jsonParser);//use objectCode to get jsonNode
		if (node == null) {
			return null;
		}

		Date date = null;

		String dateValue;
		if (node.get("$date") != null) {
			dateValue = node.get("$date").asText();
		} else {
			dateValue = node.asText();
		}

		if (dateValue.matches("^\\d+$")) {
			long time = Long.parseLong(dateValue);
			date = new Date(time);
		} else {
			//2015-08-17T12:30:44.789-4:00
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			df1.setTimeZone(TimeZone.getTimeZone("CST"));
			try {
				date = df1.parse(dateValue);
			} catch (ParseException e) {
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
				df2.setTimeZone(TimeZone.getTimeZone("CST"));
				try {
					date = df2.parse(dateValue);
				} catch (ParseException e1) {
					/**
					 * added for NLS project
					 */
					DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS-hh:mm");
					df3.setTimeZone(TimeZone.getTimeZone("CST"));
					try {
						date = df3.parse(dateValue);
					} catch (ParseException e2) {
					    /**
	                     * added for NLS project / Spain offering 
	                     */
	                    DateFormat df4 = new SimpleDateFormat("yyyy-MM-dd");
	                    df4.setTimeZone(TimeZone.getTimeZone("CST"));
	                    try {
	                        date = df4.parse(dateValue);
	                    } catch (ParseException e3) {
						throw new JsonParseException("Failed to parse date: " + node, jsonParser.getCurrentLocation(), e3);
	                    }
					}
					
				}
			}
		}
		return date;
	}

}
