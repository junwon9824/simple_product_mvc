package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Destination;
import com.example.demo.model.Plan;
import com.example.demo.model.User;
import com.example.demo.model.mapper.DestinationMapper;
import com.example.demo.model.mapper.PlanMapper;
import com.example.demo.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.getUsers();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userMapper.createUser(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(id);

	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUsername(username);
	}

	// 추가적인 메서드들
	// ...
}
