package com.user.spring.tx.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.spring.tx.dao.UserDAO;
import com.user.spring.tx.model.User;
import com.user.spring.tx.user.UserManager;

@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDAO userDAO;

	
	@Transactional
	public void insertUser(User user) {
		userDAO.insertUser(user);
	}

	
	public List<User> findAllUsers() 
	{
		return userDAO.findAllUsers();
	}

	@Transactional
	public void deleteUser(User user)
	{
		userDAO.deleteUser(user);
		
	}

	@Transactional
	public void updateUser(User user) 
	{
		userDAO.updateUser(user);
		
	}

}
