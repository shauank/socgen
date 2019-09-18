package com.sg.common.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sg.common.constant.EmployeeConstant;

/**
 * @author shpatel
 *  
 * Date deserializer to convert string to LocalDate 
 */
@Component
public class DateDeSerializer extends JsonDeserializer<LocalDate> {

	public final SimpleDateFormat formatter = new SimpleDateFormat(EmployeeConstant.CREATE_DATE_FORMAT);

	@Override
	public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		if (jp.getCurrentToken().equals(JsonToken.VALUE_STRING)) {
			return LocalDate.parse(jp.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		return null;
	}

	@Override
	public Class<LocalDate> handledType() {
		return LocalDate.class;
	}

}
