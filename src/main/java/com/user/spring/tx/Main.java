package com.user.spring.tx;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.user.spring.tx.model.User;
import com.user.spring.tx.user.UserManager;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");

		List<User> list = userManager.findAllUsers();
		System.out.println("User count: " + list.size());

		User user = new User();
		user.setUsername("TestRakuten");
		user.setName("I");
		userManager.deleteUser(user);
		//userManager.insertUser(user);
		System.out.println("User inserted!");

		list = userManager.findAllUsers();
		System.out.println("User count: " + list.size());
		
		User u = new User();
		u.setName("I");
		u.setUsername("TestRakuten");
		
		//userManager.updateUser(u);

	}
}
