
package com.link.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Main.
 * injection  依赖注入demo
 * 通过xml注入的方式
 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// 获得xml上下文对象
		com.link.spring.di.MessagePrinter printer = context.getBean(com.link.spring.di.MessagePrinter.class);
		// 获取权类限定名 测试
		printer.printMessage();
		// 调用方法
	}

}
