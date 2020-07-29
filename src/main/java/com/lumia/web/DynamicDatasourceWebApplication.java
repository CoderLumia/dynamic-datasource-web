package com.lumia.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.lumia.web.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableAsync
public class DynamicDatasourceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceWebApplication.class, args);
	}

}
