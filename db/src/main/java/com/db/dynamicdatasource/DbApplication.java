package com.db.dynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.db.dynamicdatasource.mapper")//主类写此注解，就不用每个DAO接口上写@Mapper注解了
@SpringBootApplication
public class DbApplication {

    /*测试地址  http://127.0.0.1:9999/product/1 */
	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}
}
