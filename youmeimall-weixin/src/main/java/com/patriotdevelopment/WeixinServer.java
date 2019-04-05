package com.patriotdevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@SpringBootApplication
@EnableEurekaClient
public class WeixinServer {

	public static void main(String[] args) {
		SpringApplication.run(WeixinServer.class, args);
	}
}
