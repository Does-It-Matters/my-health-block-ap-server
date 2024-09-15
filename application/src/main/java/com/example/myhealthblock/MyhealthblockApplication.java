package com.example.myhealthblock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = "com.example")
public class MyhealthblockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyhealthblockApplication.class, args);
	}

}
