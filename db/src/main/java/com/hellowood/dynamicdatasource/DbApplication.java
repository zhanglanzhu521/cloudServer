package com.hellowood.dynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hellowood.dynamicdatasource.mapper")
@SpringBootApplication
public class DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}
}
