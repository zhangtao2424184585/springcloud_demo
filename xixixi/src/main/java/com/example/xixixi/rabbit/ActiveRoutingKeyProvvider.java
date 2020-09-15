package com.example.xixixi.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Classname RoutingKeyProvvider
 * @Description TODO
 * @Date 2020/9/14 18:00
 * @Created by zhangtao
 */
public class ActiveRoutingKeyProvvider {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.115.101");
        factory.setUsername("admin");
        factory.setPassword("123");
        factory.setPort(5672);
        factory.setVirtualHost("/hello");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs","topic");

        channel.basicPublish("logs","user.a",null,"[user.d]".getBytes());
        channel.close();
        connection.close();
    }
}
