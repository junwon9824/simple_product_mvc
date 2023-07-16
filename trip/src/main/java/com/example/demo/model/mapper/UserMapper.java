package com.example.demo.model.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM users")
	List<User> getUsers();

	@Select("SELECT * FROM users WHERE id = #{id}")
	User getUserById(@Param("id") int id);

	@Select("SELECT * FROM users WHERE username = #{username}")
	User getUserByUsername(@Param("username") String username);

	@Insert("INSERT INTO users (username, email, password) VALUES (#{username}, #{email}, #{password})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void createUser(User user);

	@Update("UPDATE users SET username = #{username}, email = #{email}, password = #{password} WHERE id = #{id}")
	void updateUser(User user);

	@Delete("DELETE FROM users WHERE id = #{id}")
	void deleteUser(@Param("id") int id);

	// 추가적인 메서드들
	// ...
}
