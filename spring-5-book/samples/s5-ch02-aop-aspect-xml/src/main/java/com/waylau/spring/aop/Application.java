
package com.link.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Main.
 * Spring aop切入demo
 * 通过xml配置的方式
 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// 类路径 Xml 应用程序上下文
		// 获取bean对象
		Tiger tiger = context.getBean(Tiger.class);
		// 方法调用
		tiger.walk();
		// aop切入
		//Fighter wait for tiger...
		//Tiger is walking...
		//Fighter fight with tiger...
	}

}
