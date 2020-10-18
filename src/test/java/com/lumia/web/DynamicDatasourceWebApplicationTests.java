package com.lumia.web;

import com.lumia.web.service.AnnotationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDatasourceWebApplicationTests {

//	@Resource
//	private AnnotationService annotationServiceTest;
//
//	@Resource
//	private AnnotationService annotationServiceProd;

	@Autowired
	private AnnotationService annotationServiceTest;

	@Autowired
	private AnnotationService annotationServiceProd;

	/**
	 * @Resource是根据字段的名称进行注入的，若没有指定name和type则自动按照byName的方式进行匹配，若没有匹配，则回退为一个原始类型进行匹配
	 * @Autowired 会先根据类型进行匹配，若存在多个同一类型的bean，会根据字段的名称进行注入
	 * 推荐使用@Resource注解，并且这个注解属于J2EE,减少了与Spring的耦合
	 */
	@Test
	public void contextLoads() {
		String s1 = annotationServiceTest.sayHello();
		String s2 = annotationServiceProd.sayHello();
		System.out.println(s1);
		System.out.println(s2);
	}




}
