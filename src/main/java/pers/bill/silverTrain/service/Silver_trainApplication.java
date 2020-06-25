package pers.bill.silverTrain.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class Silver_trainApplication {

	public static void main(String[] args) {
		SpringApplication.run(Silver_trainApplication.class, args);
	}

}
