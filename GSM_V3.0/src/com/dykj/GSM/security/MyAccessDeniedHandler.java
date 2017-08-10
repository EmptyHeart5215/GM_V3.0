package com.dykj.GSM.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyAccessDeniedHandler implements AccessDeniedHandler {
	private String accessDeniedUrl;

	public MyAccessDeniedHandler() {
	}

	public MyAccessDeniedHandler(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// response.sendRedirect("/GSM_V3.0" + accessDeniedUrl);
		String deniedMessage = accessDeniedException.getMessage();
		String rp = request.getRequestURI();
		request.getSession().setAttribute("ACCESS_DENIED_MSG", deniedMessage);
		ObjectMapper objectMapper = new ObjectMapper();
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(),
				JsonEncoding.UTF8);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("status", false);
		data.put("info", deniedMessage);
		objectMapper.writeValue(jsonGenerator, data);
	}

	public String getAccessDeniedUrl() {
		return accessDeniedUrl;
	}

	public void setAccessDeniedUrl(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}
}
