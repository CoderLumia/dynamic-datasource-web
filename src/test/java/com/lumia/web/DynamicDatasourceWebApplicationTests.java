package com.lumia.web;

import com.lumia.web.service.AnnotationService;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;

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

	@Test
	public void testArrayList() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i + "");
		}
		Iterator<String> iterator = list.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			String s = iterator.next();
			if ("3".equals(s)) {
				list.remove(s);
			}
			i++;
		}
	}

	@Test
	public void testArrayList1() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i + "");
		}
		for (int i = 0; i < list.size(); i++) {
			if (i == 3) {
				list.remove(3);
			}
		}
	}

	@Test
	public void testSet() {
		Set<String> set = new HashSet<>();
		boolean add = set.add(null);
	}

	@Test
	public void testTreeMap() {
		TreeMap<String, String> treeMap = new TreeMap<>();
		String put = treeMap.put("hello", "world");
		System.out.println(put);
		String put1 = treeMap.put("hello", "world1");
		System.out.println(put1);
	}


	@Test
	public void testTreeSet() {
		Set<String> set = new TreeSet<>();
		set.add(null);
	}

	@Test
	public void testList() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			list.add(i);
		}
		int currentPage = 1;
		int pageSize = 10;
		List<Integer> collect = list.stream().skip((currentPage - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
		collect.forEach(System.out::println);
	}




	@Test
	public void test1() {
		int a = 2;
		int b = 3;
		int c = 4;
		a = b = c;
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		System.out.println("c:" + c);
	}

}
