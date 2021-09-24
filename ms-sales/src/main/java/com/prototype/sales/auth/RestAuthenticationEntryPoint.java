package com.prototype.sales.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prototype.sales.exeption.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component("restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException {

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		ObjectMapper objectMapper = new ObjectMapper();

		ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED);
		apiError.setMessage(authException.getMessage());

		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String result = objectMapper.writeValueAsString(apiError);
		writer.print(result);
		writer.flush();

	}
}
