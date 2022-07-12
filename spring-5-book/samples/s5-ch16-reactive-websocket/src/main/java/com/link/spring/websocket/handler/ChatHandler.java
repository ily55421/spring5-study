
package com.link.spring.websocket.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Mono;

/**
 * Chat Handler.
 */
@Component
public class ChatHandler implements WebSocketHandler {

	@Override
	public Mono<Void> handle(WebSocketSession session) {
		return session.send(
				session.receive().map(msg 
						-> session.textMessage(session.getId() + ":" + msg.getPayloadAsText())));
	}

}
