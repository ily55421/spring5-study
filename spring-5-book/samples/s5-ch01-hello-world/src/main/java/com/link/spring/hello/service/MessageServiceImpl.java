
package com.link.spring.hello.service;

import org.springframework.stereotype.Service;

/**
 * Message Service Impl.
 */
@Service
public class MessageServiceImpl implements MessageService {
	
	public String getMessage() {
		return "Hello World!";
	}

}
