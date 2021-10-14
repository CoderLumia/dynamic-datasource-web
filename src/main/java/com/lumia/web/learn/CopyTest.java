package com.lumia.web.learn;

import cn.hutool.core.bean.BeanUtil;
import com.lumia.web.entity.User;
import com.lumia.web.entity.UserCopy;

public class CopyTest {

    public static void main(String[] args) {

        User user = new User();
        user.setId(1);
        user.setPassword("123456");
        user.setUsername("zhang");
        user.setEmail("123@qq.com");
        UserCopy userCopy = new UserCopy();
        BeanUtil.copyProperties(user, userCopy);
    }
}
