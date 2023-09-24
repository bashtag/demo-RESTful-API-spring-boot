package com.hibernate.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(scanBasePackages = {
// 	"com.hibernate.demo.Entities",
// 	"com.hibernate.demo.DataAccess",
// 	"com.hibernate.demo.Business",
// 	"com.hibernate.demo.restApi"
// })
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
