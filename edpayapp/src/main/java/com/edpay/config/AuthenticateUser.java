package com.edpay.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.edpay.dao.IUserDAO;
import com.edpay.dao.IUserRoleDAO;
import com.edpay.data.type.StatusCode;
import com.edpay.exceptionHandler.IIErrorCodeDescription;
import com.edpay.exceptionHandler.Validate;
import com.edpay.model.User;
import com.edpay.model.UserRole;
import com.edpay.response.UserDetailsOutbound;


@Service
public class AuthenticateUser {
	
	private static final org.slf4j.Logger log = LoggerFactory
			.getLogger(AuthenticateUser.class);
	
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IUserRoleDAO userRoleDAO;
	
	
	@Transactional
	public String authenticate(String token, HttpServletRequest httpRequest) {
	log.info("Incoming request IP :: " + httpRequest.getRemoteAddr());
	log.info("Incoming request URI:: " + httpRequest.getRequestURL());
	
	System.out.println("");
	List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
	String[] args = token.split(":");
	Validate.assertTrue(args.length == 2, IIErrorCodeDescription.INVALID_CREDENTIALS);
	String username = args[0];
	System.out.println("username:"+username);
	String key = args[1];
	System.out.println("key:"+key);
	
	User user = userDAO.findByEmailAddressAndStatus(username,StatusCode.ACTIVE.getStatusCode());
	if (user == null) {
		log.info("User not avilable");
		Validate.notNull(null, IIErrorCodeDescription.INVALID_CREDENTIALS);
		// return username;
	}
	String md5Value = org.apache.commons.codec.digest.DigestUtils.md5Hex(key);
	if (!md5Value.equals(user.getPassword())) {
		log.info("User Password Not match");
		Validate.notNull(null, IIErrorCodeDescription.INVALID_CREDENTIALS);
		// return username;
	}
	if (!(user.getStatus() == StatusCode.ACTIVE.getStatusCode())) {
		log.info("User not enabled");
		Validate.notNull(null, IIErrorCodeDescription.USER_DISABLED);
		// return username;
	}
	UserRole userRole = userRoleDAO.findByUser(user);
	authorities.add(new SimpleGrantedAuthority(userRole.getRole()
			.getRoleName()));

	UserDetailsOutbound userContext = new UserDetailsOutbound();
	userContext.setUserName(user.getUserName());
	userContext.setEmailId(user.getEmailAddress());
	userContext.setUserRole(userRole.getRole().getRoleName());
	userContext.setUserId(user.getUserId());

	Authentication authentication = new UsernamePasswordAuthenticationToken(
			userContext, null, authorities);
	SecurityContextHolder.getContext().setAuthentication(authentication);

	return username;
}}
