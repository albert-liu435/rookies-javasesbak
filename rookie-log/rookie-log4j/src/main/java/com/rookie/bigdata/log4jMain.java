package com.rookie.bigdata;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * @Classname log4jMain
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/30 12:02
 * @Version 1.0
 */
public class log4jMain {

    // public static final Logger logger= LogManager.getLogger(log4jMain.class);
    @Test
    public void test1() {
        //log4j的初始化配置，如果resources中没有log4j.properties文件的情况下，如果不配置则会报错
         BasicConfigurator.configure();

        Logger logger = Logger.getLogger(log4jMain.class);
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");


    }


    @Test
    public void test2() {
        //log4j的初始化配置，如果resources中没有log4j.properties文件的情况下，如果不配置则会报错
       // BasicConfigurator.configure();

        Logger logger = Logger.getLogger(log4jMain.class);
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");


    }



}
