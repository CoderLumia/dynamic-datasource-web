package com.lumia.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lumia.web.mapper")
public class DynamicDatasourceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceWebApplication.class, args);
	}

}
