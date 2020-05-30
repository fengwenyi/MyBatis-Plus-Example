package com.fengwenyi.mybatis_plus_example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fengwenyi.mybatis_plus_example.db.dao")
@SpringBootApplication
public class MyBatisPlusExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisPlusExampleApplication.class, args);
	}

}
