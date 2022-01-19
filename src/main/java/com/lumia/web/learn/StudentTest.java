package com.lumia.web.learn;



import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTest {

    public static void main(String[] args) throws Throwable {

//        studentTest();
//
//        Thread.sleep(1000);

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        List<Integer> collect = Stream.iterate(1, item -> ++item).limit(100000).collect(Collectors.toList());
        CopyOnWriteArraySet<Integer> integers = new CopyOnWriteArraySet<>();
//        HashSet<Integer> integers = new HashSet<>();

//        for (Integer integer : collect) {
//            executorService.submit(() -> {
//               integers.add(integer);
//            });
//        }
//
//        Thread.sleep(10000);
//
//        System.out.println(integers.size());


        String str1 = new StringBuilder("computer").append("science").toString();
        System.out.println(str1);
        System.out.println(str1 == str1.intern());

        System.out.println();
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2 == str2.intern());

    }

    public static void studentTest() throws Throwable {
        Student lin = new Student("lin", 13);
        lin.finalize();
    }
}
