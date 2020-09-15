package com.example.xixixi.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Classname ActiveRouteKeyCusumer1
 * @Description TODO
 * @Date 2020/9/15 11:06
 * @Created by zhangtao
 */
public class ActiveRouteKeyCusumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.115.101");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("123");
        factory.setVirtualHost("/hello");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs","topic");
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,"logs","user.*");
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });

    }
}
