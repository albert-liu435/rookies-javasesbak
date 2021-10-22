package com.rookie.bigdata.lang.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Classname MyAnnotation
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/22 16:51
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String[] value() default "张三";

}
