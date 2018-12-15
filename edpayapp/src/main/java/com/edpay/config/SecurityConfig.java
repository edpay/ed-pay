package com.edpay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
//@PropertySource("file:${propFile.loc}.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${server.servlet.context-path}")
	private String context;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("WEB security Config Called");
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/context/**").authenticated().anyRequest().permitAll();
        //http.authorizeRequests().antMatchers("/context/register").permitAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http.addFilterBefore(new LoginFilter(), BasicAuthenticationFilter.class);
        http.logout().logoutSuccessUrl("/login");
        
    }
}
