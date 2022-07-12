
package com.link.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Application Main.
 * spring 注入demo
 */
@ComponentScan
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		// 注释配置应用程序上下文  获取上下文对象
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		// 获取bean对象
		printer.printMessage();
		// 方法调用
		// Hello World!
	}

}
