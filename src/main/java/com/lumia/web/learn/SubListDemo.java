package com.lumia.web.learn;


import cn.hutool.core.util.IdUtil;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo {

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    public static String generateShortUuid(String uuid) {
        StringBuilder shortBuffer = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        List<Integer> subList = list.subList(5, 10);

        subList.add(10);

        subList.forEach(System.out::print);

        System.out.println();

        list.forEach(System.out::print);

        for (int i = 0; i < 10000000; i++) {
            String uuid = IdUtil.simpleUUID();

            System.out.println(uuid);
        }
    }
}
