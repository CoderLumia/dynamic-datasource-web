package com.lumia.web.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    //类型
    String type() default "";

    //模块
    String module() default "";

    //描述
    String desc() default "";
}
