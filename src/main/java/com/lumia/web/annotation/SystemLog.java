package com.lumia.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
public @interface SystemLog {

    //类型
    String type() default "";

    //模块
    String module() default "";

    //描述
    String desc() default "";
}
