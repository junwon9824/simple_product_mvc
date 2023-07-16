package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.dto.LoginForm;

@RestController
public class AuthenticationController {
	private final AuthenticationManager authenticationManager;

	@Autowired
	public AuthenticationController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
		// 로그인 정보를 받아와서 사용자 인증 작업 수행
		Authentication authentication = new UsernamePasswordAuthenticationToken(loginForm.getUsername(),
				loginForm.getPassword());

		Authentication result = authenticationManager.authenticate(authentication);
		SecurityContextHolder.getContext().setAuthentication(result);

		return ResponseEntity.ok("Login successful");
	}
}
