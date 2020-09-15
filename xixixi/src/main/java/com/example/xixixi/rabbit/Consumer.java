package com.example.xixixi.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Classname Consumer
 * @Description TODO
 * @Date 2020/9/8 14:25
 * @Created by zhangtao
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("123");
        factory.setHost("192.168.115.101");
        factory.setPort(5672);
        factory.setVirtualHost("/hello");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        /*
        * 第一个参数是绑定队列
        * 第二个参数是是否持久化
        * 第三个参数是是否独占
        * 第四个参数是是否自动删除
        *
        * */
        channel.queueDeclare("hello",false,false,false,null);
        channel.basicQos(1);
        channel.basicConsume("hello",false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
