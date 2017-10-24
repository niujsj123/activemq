package com.ju.jms.consumer.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.ju.jms.producer.spring.UserInfo;

public class SpringQueueListener implements MessageListener {

	public void onMessage(Message message) {
		ObjectMessage msg = (ObjectMessage) message;
		try {
			UserInfo userInfo = (UserInfo) msg.getObject();
			System.out.println("---------->"+userInfo);
		} catch (JMSException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}
