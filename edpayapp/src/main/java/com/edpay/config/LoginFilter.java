package com.edpay.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;


@Configurable(preConstruction = true)
public class LoginFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("checking the authentication");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println(""+SecurityContextHolder.getContext().getAuthentication());
		System.out.println(""+((HttpServletRequest)request).getRequestURL());
		String token = httpRequest.getHeader("token");
		//String token = "vedavyasa42@gmail.com:12345678";
		String username = null;
		if (token != null) {
			username = StaticContextHolder.getBean(AuthenticateUser.class)
					.authenticate(token, (HttpServletRequest)httpRequest);
		}
		chain.doFilter(request, response);
	}

}
