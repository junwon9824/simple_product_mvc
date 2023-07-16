package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() // CSRF 보안 비활성화 (REST API에서는 CSRF를 일반적으로 사용하지 않음)
				.authorizeRequests().antMatchers("/login").permitAll() // "/login" 경로에 대해 인증 없이 접근 허용
				.anyRequest().authenticated() // 나머지 모든 경로는 인증이 필요
				.and().httpBasic(); // HTTP Basic 인증 사용
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl); // 사용자 정의 UserDetailsService를 등록하여 사용자 인증 처리
	}

}
