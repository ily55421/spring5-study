package com.link.spring.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.link.spring.mvc.vo.User;


/**
 * Hello 控制器.

 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
	    return "Hello World! Welcome to visit link.com!";
	}
	
	@RequestMapping("/hello/way")
	public User helloWay() {
	    return new User("link", 30);
	}
}
