package com.lumia.web.learn;

import cn.hutool.core.util.IdUtil;

public class TestSimpleUUID {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            String uuid = IdUtil.simpleUUID();
            System.out.println(uuid);
        }
    }
}
