package com.link.spring.jms.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Queue Message Listener.

 */
public class QueueMessageListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("ConsumerMessageListener收到了文本消息：\t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
