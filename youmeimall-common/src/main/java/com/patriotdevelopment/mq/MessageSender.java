package com.patriotdevelopment.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class MessageSender {
	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	public void send(String queue_name, String json) {
		Destination destination = new ActiveMQQueue(queue_name);
		jmsTemplate.convertAndSend(destination, json);
	}
}