package com.dykj.GSM.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer {
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formattedDate = formatter.format(value);
		jgen.writeString(formattedDate);
	}

	@Override
	public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		// TODO Auto-generated method stub

	}

}