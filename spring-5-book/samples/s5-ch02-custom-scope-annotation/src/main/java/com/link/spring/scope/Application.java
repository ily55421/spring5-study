
package com.link.spring.scope;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.link.spring.scope.service.MessageService;

/**
 * Application Main.
 */
public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		@SuppressWarnings("resource")
		ApplicationContext context = 
			new AnnotationConfigApplicationContext(AppConfig.class);
		/*
		MessageService messageService = context.getBean(MessageService.class);
		messageService.getMessage();
 
		MessageService messageService2 = context.getBean(MessageService.class);
		messageService2.getMessage();
		*/

		CompletableFuture<String> task1 = CompletableFuture.supplyAsync(()->{
            //模拟执行耗时任务
            MessageService messageService = context.getBean(MessageService.class);
			messageService.getMessage();
	 
			MessageService messageService2 = context.getBean(MessageService.class);
			messageService2.getMessage();
            //返回结果
            return "result";
        });
		
		CompletableFuture<String> task2 = CompletableFuture.supplyAsync(()->{
            //模拟执行耗时任务
            MessageService messageService = context.getBean(MessageService.class);
			messageService.getMessage();
	 
			MessageService messageService2 = context.getBean(MessageService.class);
			messageService2.getMessage();
            //返回结果
            return "result";
        });
		
		task1.get();
		task2.get();
		
		
	}

}
