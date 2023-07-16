package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserService userService;

	public UserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 사용자를 조회하는 로직을 구현하고 UserDetails 객체를 반환합니다.
		// 예시: userService.getUserByUsername(username);
		// ...
		// UserDetails 객체 반환

		User user = userService.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");

		}

		// UserDetails 객체 반환
		return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
				.password(user.getPassword()).roles("USER") // 사용자의 역할(role) 설정
				.build();
	}
}
