package com.lumia.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.lumia.web.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class DynamicDatasourceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceWebApplication.class, args);
	}

}
