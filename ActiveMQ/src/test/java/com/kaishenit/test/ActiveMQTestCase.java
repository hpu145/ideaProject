package com.kaishenit.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

/**
 * Created by zhangyu on 2017/11/22.
 */
public class ActiveMQTestCase {


    @Test
    public void sendMessageToQueue() throws JMSException {
        //1.创建ConnectionFactory
        String brokerUrl = "tcp://localhost:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        //2.创建Connection
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //3.创建Session，通过参数设置事务级别
        Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
        //4.创建Destination 目的地对象
        Destination destination = session.createQueue("text-Message");
        //5.创建消息的生产者
        MessageProducer messageProducer = session.createProducer(destination);
        //6.创建一条消息
        TextMessage textMessage = session.createTextMessage("测试成功-1");
        //7.发送消息
        messageProducer.send(textMessage);
        //提交事务
        session.commit();
        //8.释放资源
        messageProducer.close();
        session.close();
        connection.close();

    }


    @Test
    public void consumerMessageFromQueue() throws JMSException, IOException {
        //1.创建ConnectionFactory
        String brokerUrl = "tcp://localhost:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        //2.创建Connection
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //3.创建Session
        Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
        //4.创建Destination 目的地对象
        Destination destination = session.createQueue("text-Message");
        //5.创建消费者
        MessageConsumer messageConsumer = session.createConsumer(destination);
        //6.消费消息，监听队列中的消息，若有新消息，会执行onMessage方法
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        //7.释放资源
        messageConsumer.close();
        session.close();
        connection.close();
    }








}
