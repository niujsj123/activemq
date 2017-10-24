package com.ju.jms.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueSender {

	public static void main(String[] args) throws JMSException {
		//五部曲：
		ConnectionFactory factory = new ActiveMQConnectionFactory("failover:(tcp://192.168.20.241:61626,tcp://192.168.20.241:61616)?randomize=true");
		Connection conn = factory.createConnection();
//		conn.setClientID("111");
		Session session = conn.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		conn.start();
		Queue queue = session.createQueue("test1");
//		Topic topic = session.createTopic("123");
//		MessageProducer producer = session.createProducer(topic);
//		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		MessageProducer producer = session.createProducer(queue);
		Message message = session.createTextMessage("8888");
		producer.send(message);
//		session.commit();
//		 session.close();  
//		 conn.close();  
	}

}
