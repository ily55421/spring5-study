package com.link.spring.jms.topic;

import javax.jms.JMSException;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Topic Message Listener 2.

 */
public class TopicMessageListener2 implements MessageListener {

	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("TopicMessageListener2监听到消息 \t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
