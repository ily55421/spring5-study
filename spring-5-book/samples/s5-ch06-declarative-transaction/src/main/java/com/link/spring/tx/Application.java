
package com.link.spring.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.link.spring.tx.service.UserService;
import com.link.spring.tx.vo.User;

/**
 * Application Main.
 * 声明式事务控制
 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService UserService = context.getBean(UserService.class);
		UserService.saveUser(new User("lin k", 30));
	}

}
