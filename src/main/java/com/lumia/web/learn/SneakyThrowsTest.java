package com.lumia.web.learn;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;

@Slf4j
public class SneakyThrowsTest {

    @SneakyThrows
    public String query() {
        File file = new File("fdsgfdgfsd");
        FileInputStream fileInputStream = new FileInputStream(file);
        return "fdsgsdfgsd";
    }

    public static void main(String[] args) {
        SneakyThrowsTest sneakyThrowsTest = new SneakyThrowsTest();
        sneakyThrowsTest.query();
    }
}
