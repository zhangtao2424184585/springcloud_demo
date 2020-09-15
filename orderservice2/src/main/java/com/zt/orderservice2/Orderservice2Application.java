package com.zt.orderservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@ComponentScan(value = "com.zt")

public class Orderservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Orderservice2Application.class, args);
	}

}
