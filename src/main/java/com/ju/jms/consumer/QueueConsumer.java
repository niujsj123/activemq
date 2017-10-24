package com.ju.jms.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;


public class QueueConsumer {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = null;
		Connection conn = null;
		Session session = null;
		Queue queue = null;
		MessageConsumer consumer = null;
		
		factory = new ActiveMQConnectionFactory("failover:(tcp://192.168.20.241:61626,tcp://192.168.20.241:61616)?randomize=true");
		conn = factory.createConnection();
//		conn.setClientID("2104");
		conn.start();
//		session = conn.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
		session = conn.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		queue = session.createQueue("test1");
//		Topic topic = session.createTopic("123");
//		consumer = session.createDurableSubscriber(topic, "2104");
//		consumer = session.createConsumer(topic);
		consumer = session.createConsumer(queue);
		Message message = consumer.receive();
		TextMessage text = (TextMessage) message;
		System.out.println(text.getText());
//		boolean run =true;
//		while(run){
			// 接收消息，不等待
			/*consumer.setMessageListener(new MessageListener() {
				
				public void onMessage(Message message) {
					TextMessage text = (TextMessage) message;
					try {
						System.out.println(text.getText());
					} catch (JMSException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					
				}
			});*/
           /* Message message = consumer.receiveNoWait();
//            session.commit();
            if (message != null) {

                // 实际应用时，根据需要转换类型，这里是普通文本，所以转为TextMessage
                System.out.println("收到的message是:"
                        + ((TextMessage) message).getText());
                run = false;
            } else {
                System.out.println("no messsage.");
            }

            // 休息1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			
		}*/
	/*	consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				TextMessage text = (TextMessage) message;
				try {
					System.out.println(text.getText());
				} catch (JMSException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		});*/
//		TextMessage message = (TextMessage) consumer.receive();
//		session.commit();
//		System.out.println(message.getText());
	}

}
