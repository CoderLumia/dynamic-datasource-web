package com.lumia.web;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.lumia.web.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
@NacosPropertySource(dataId = "dynamic-datasource-web", autoRefreshed = true)
@EnableAsync
public class DynamicDatasourceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceWebApplication.class, args);
	}

}
