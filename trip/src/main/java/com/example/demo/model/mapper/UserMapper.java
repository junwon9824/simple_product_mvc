package com.example.demo.model.mapper;

import com.example.demo.model.User;

public interface UserMapper {
	User getUserById(int id);

	User getUserByUsername(String username);

	void createUser(User user);
	// 추가적인 메서드들
	// ...
}
