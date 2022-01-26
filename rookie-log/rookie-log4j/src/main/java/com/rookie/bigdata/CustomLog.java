package com.rookie.bigdata;

import org.apache.log4j.Logger;

/**
 * @Classname CustomLog
 * @Description 自定义日志文件，将自定义的日志全部输出到指定的文件中
 * @Author rookie
 * @Date 2021/12/31 10:51
 * @Version 1.0
 */
public class CustomLog {

    public static final Logger logger = Logger.getLogger(log4jMain.class);

    public static void main(String[] args) {

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
