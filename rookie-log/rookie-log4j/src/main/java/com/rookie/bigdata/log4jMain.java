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

    /**
     * log日志输出到控制台
     */
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


    /**
     * 测试打印日志到数据库
     */
    @Test
    public void test3() {
        //log4j的初始化配置，如果resources中没有log4j.properties文件的情况下，如果不配置则会报错
        // BasicConfigurator.configure();

        Logger logger = Logger.getLogger(log4jMain.class);

        for (int i = 0; i < 100; i++) {
            logger.fatal("fatal");
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");

        }


    }

    /**
     * FileAppender示例 测试打印日志到文件中
     */
    @Test
    public void test4() {
        //log4j的初始化配置，如果resources中没有log4j.properties文件的情况下，如果不配置则会报错
        // BasicConfigurator.configure();

        Logger logger = Logger.getLogger(log4jMain.class);

        for (int i = 0; i < 1000000; i++) {
            logger.fatal("fatal");
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");

        }


    }


    /**
     * DailyRollingFileAppender 测试打印日志到文件中,按照分钟进行切割日志
     */
    @Test
    public void test5() {
        //log4j的初始化配置，如果resources中没有log4j.properties文件的情况下，如果不配置则会报错
        // BasicConfigurator.configure();

        Logger logger = Logger.getLogger(log4jMain.class);

        for (int i = 0; i < 1000000; i++) {
            logger.fatal("fatal");
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");

        }


    }

    /**
     * RollingFileAppender进行日志输出
     */
    @Test
    public void test6() {
        //log4j的初始化配置，如果resources中没有log4j.properties文件的情况下，如果不配置则会报错
        // BasicConfigurator.configure();

        Logger logger = Logger.getLogger(log4jMain.class);

        for (int i = 0; i < 1000000; i++) {
            logger.fatal("fatal");
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");

        }


    }

}
