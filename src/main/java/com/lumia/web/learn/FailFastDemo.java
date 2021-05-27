package com.lumia.web.learn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FailFastDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

//        Iterator<String> iterator = list.iterator();
//
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//
//            if ("3".equals(next)) {
//                list.remove(next);
//            }
//        }

        ListIterator<String> stringListIterator = list.listIterator();

        while (stringListIterator.hasNext()) {

            String next = stringListIterator.next();

            if ("3".equals(next)) {
                stringListIterator.remove();
            }
        }

        list.forEach(System.out::print);
    }
}
