
package com.link.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Main.

 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
		//Get messageServiceImpl
		//Not exists messageServiceImpl
		//Hello World! Way Lau, age is 30
	}

}
