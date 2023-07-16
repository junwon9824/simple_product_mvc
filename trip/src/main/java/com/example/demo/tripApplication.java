package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.model.mapper")

public class tripApplication {

	public static void main(String[] args) {
		SpringApplication.run(tripApplication.class, args);
	}

}