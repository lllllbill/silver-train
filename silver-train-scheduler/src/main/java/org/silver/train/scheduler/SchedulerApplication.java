package org.silver.train.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SchedulerApplication {

	public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);
    }
}
