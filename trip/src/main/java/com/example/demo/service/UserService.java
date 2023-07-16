package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Destination;
import com.example.demo.model.Plan;
import com.example.demo.model.User;

public interface UserService {
	List<User> getAllUsers();

	User getUserById(int id);

	void createUser(User user);

	void deleteUser(int id);

	User getUserByUsername(String username);

	// 추가적인 메서드들
	// ...
}
