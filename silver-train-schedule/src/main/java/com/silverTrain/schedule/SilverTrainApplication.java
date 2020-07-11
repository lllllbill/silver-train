package com.silverTrain.schedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.silverTrain.schedule.mapper")
public class SilverTrainApplication {

	public static void main(String[] args) {
		 SpringApplication.run(SilverTrainApplication.class, args);
	}

}
