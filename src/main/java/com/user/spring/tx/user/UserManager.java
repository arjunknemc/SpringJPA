package com.user.spring.tx.user;

import java.util.List;

import com.user.spring.tx.model.User;

public interface UserManager {

	void insertUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
	List<User> findAllUsers();
}
