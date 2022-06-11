package com.gobi.edu.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

	//@JmsListener(destination = "javatech-queue")
	public void consumeMessage(String message) {
		logger.info("Message received from activemq queue---"+message);
	}
}
