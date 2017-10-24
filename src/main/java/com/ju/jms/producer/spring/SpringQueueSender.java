package com.ju.jms.producer.spring;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
//@Service
public class SpringQueueSender {
	/*@Autowired
	JmsTemplate jmsTemplate;*/

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-jms.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		jmsTemplate.send(new MessageCreator(){

			public Message createMessage(Session session) throws JMSException {
				ObjectMessage message = session.createObjectMessage();
				UserInfo userInfo = new UserInfo("lisi",26);
				message.setObject(userInfo);
				return message;
			}
			
		});
		try {
			System.out.println("send start");
			System.in.read();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}
