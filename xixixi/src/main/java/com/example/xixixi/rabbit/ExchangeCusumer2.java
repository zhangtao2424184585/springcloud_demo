package com.example.xixixi.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Classname ExchangeCusumer1
 * @Description TODO
 * @Date 2020/9/14 17:40
 * @Created by zhangtao
 */
public class ExchangeCusumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.115.101");
        factory.setUsername("admin");
        factory.setPassword("123");
        factory.setPort(5672);
        factory.setVirtualHost("/hello");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queue = channel.queueDeclare().getQueue();

        channel.exchangeDeclare("ceshiexchange","fanout");
        channel.queueBind(queue,"ceshiexchange","");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });

    }
}
