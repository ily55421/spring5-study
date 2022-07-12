package com.link.spring.jms.queue;


import javax.print.attribute.standard.Destination;

/**
 * Consumer Service.
 */
public class ConsumerServiceImpl implements ConsumerService {

	private JmsTemplate jmsTemplate;

	/**
	 * 接受消息
	 */
	@Override

	public void receive(Destination queueDestination) {
		TextMessage tm = (TextMessage) jmsTemplate.receive(queueDestination);
		try {
			System.out.println("ConsumerService从队列"
					+ queueDestination.toString() + "收到了消息：\t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

}
