package com.silverTrain.schedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.silverTrain")
@MapperScan("com.silverTrain.schedule.mapper")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SilverTrainApplication {

	public static void main(String[] args) {
		 SpringApplication.run(SilverTrainApplication.class, args);
	}

}
