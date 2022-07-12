
package com.link.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.link.spring.jdbc.service.UserService;
import com.link.spring.jdbc.vo.User;

/**
 * Application Main.
 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService UserService = context.getBean(UserService.class);
		
		List<User> users = UserService.listUser();
		
		for (User user : users) {
			System.out.println(user);
		}
	}

}
