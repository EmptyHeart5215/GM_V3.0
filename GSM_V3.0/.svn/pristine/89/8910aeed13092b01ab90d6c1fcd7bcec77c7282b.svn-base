package com.dykj.GSM.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.utils.MySession;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	protected final Log logger = LogFactory.getLog(this.getClass());

	private final RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		ObjectMapper objectMapper = new ObjectMapper();
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(),
				JsonEncoding.UTF8);
		try {
			SessionModel model = (SessionModel) authentication.getPrincipal();
			String desString = MySession.getInfoDesString(model);

			String res = "{\"ukey\": \"" + desString + "\",\"usercode\": \"" + model.getCode() + "\",\"gridcode\":\""
					+ model.getGridCode() + "\",\"departmentcode\":\"" + model.getDepartmentCode()
					+ "\",\"rolecode\":\"" + model.getRoleCode() + "\",\"realname\":\"" + model.getRealName() + "\"}";
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("status", true);
			data.put("info", res);
			objectMapper.writeValue(jsonGenerator, data);
		} catch (Exception ex) {
			throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
		}
	}

}
