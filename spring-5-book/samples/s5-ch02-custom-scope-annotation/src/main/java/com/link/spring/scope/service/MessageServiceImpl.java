
package com.link.spring.scope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Message Service Impl.

 */
@Scope("threadScope")
@Service
public class MessageServiceImpl implements MessageService {
	
	public String getMessage() {
		return "Hello World!";
	}

}
