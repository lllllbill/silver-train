package org.silver.train.spider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpiderApplication {

	public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
    }

}
