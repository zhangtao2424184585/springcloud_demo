package com.example.xixixi.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Classname ExchangeProvider
 * @Description TODO
 * @Date 2020/9/14 17:19
 * @Created by zhangtao
 */
public class ExchangeProvider {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.115.101");
        factory.setUsername("admin");
        factory.setPassword("123");
        factory.setPort(5672);
        factory.setVirtualHost("/hello");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("ceshiexchange","fanout");
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("ceshiexchange","",null,("haha:"+i).getBytes());
        }
        channel.close();

        connection.close();

    }
}
