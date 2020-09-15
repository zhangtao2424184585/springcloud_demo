package com.example.xixixi.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Classname Provide
 * @Description TODO
 * @Date 2020/9/8 14:11
 * @Created by zhangtao
 */
public class Provide {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("123");
        factory.setHost("192.168.115.101");
        factory.setPort(5672);
        factory.setVirtualHost("/hello");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("","hello",null,("xixi:"+i).getBytes());

        }
        channel.close();
        connection.close();
    }
}
