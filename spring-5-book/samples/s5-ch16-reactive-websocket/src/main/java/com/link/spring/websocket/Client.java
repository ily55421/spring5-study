
package com.link.spring.websocket;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.reactive.socket.client.JettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

/**
 *
 */
public class Client {

	/**
	 * @param args
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws URISyntaxException {
		WebSocketClient client = new JettyWebSocketClient();

		URI url = new URI("ws://localhost:8080/chat");
		

		
		client.execute(url, session ->
		        session.receive()
		                .doOnNext(System.out::println)
		                .then());

	}

}
