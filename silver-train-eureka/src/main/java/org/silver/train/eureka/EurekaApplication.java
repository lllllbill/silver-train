package org.silver.train.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
	//eureka-server start
	public static void main(String[] args) {
		 SpringApplication.run(EurekaApplication.class, args);
	}

}
