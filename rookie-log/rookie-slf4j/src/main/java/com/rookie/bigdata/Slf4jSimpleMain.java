package com.rookie.bigdata;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname Slf4jSimpleMain
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/11 10:13
 * @Version 1.0
 */
public class Slf4jSimpleMain {


    public final static Logger LOGGER = LoggerFactory.getLogger(Slf4jSimpleMain.class);


    @Test
    public void test1() {

        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.trace("trace");
        LOGGER.warn("warn");
        LOGGER.error("error");

        String name = "zhangsan";
        Integer age = 23;
        LOGGER.info("用户：{},{}", name, age);



        //3、打印堆栈信息
        try {
            int i = 1/0;
        }catch (Exception e){
            LOGGER.error("报错",e);
        }

    }

}
