package com.java.util.logging;

import jdk.internal.util.xml.impl.Input;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.*;

/**
 * @Classname LoggerMain
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/24 15:41
 * @Version 1.0
 */
public class LoggerMain {

//   public static final Logger logger = Logger.getLogger("com.java.util.logging");
//    public static void main(String[] args) {
//
//      //  logger.setLevel(Level.ALL);
//
//        logger.info("开始执行...");
//        logger.warning("大于info级别...");
//        logger.fine("小于info级别...");
//        logger.severe("结束执行...");
//    }

    @Test
    public void test1() {
        //默认使用rootLogger
        Logger logger = Logger.getLogger("com.java.util.logging");
        logger.setLevel(Level.WARNING);
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

    }

    @Test
    public void test2() {
        Logger logger = Logger.getLogger("com.java.util.logging");
        //不采用父logger,这里指的是rootlogger
        logger.setUseParentHandlers(false);
        //自定义Handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //设置格式化
        consoleHandler.setFormatter(new XMLFormatter());
        //分别设置handler和logger的等级
        consoleHandler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
        //添加handler到logger
        logger.addHandler(consoleHandler);
        //输出不同等级的日志
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");


    }


    @Test
    public void test3() throws IOException {
        Logger logger = Logger.getLogger("com.java.util.logging");
        //不采用父logger,这里指的是rootlogger
        logger.setUseParentHandlers(false);
        //自定义Handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //设置格式化
        consoleHandler.setFormatter(new XMLFormatter());

        //文件处理器
        FileHandler fileHandler = new FileHandler("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\resources\\com\\java\\util\\logging\\java.log");
        fileHandler.setFormatter(new XMLFormatter());


        //分别设置handler和logger的等级
        consoleHandler.setLevel(Level.ALL);
        // logger.setLevel(Level.ALL);
        //添加handler到logger
        logger.addHandler(consoleHandler);


        //分别设置handler和logger的等级
        fileHandler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
        //添加handler到logger
        logger.addHandler(fileHandler);

        //输出不同等级的日志
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");


    }


    @Test
    public void test4() throws IOException {
        Logger logger1 = Logger.getLogger("com.java.util.logging");

        Logger logger2 = Logger.getLogger("com.java.util");

        System.out.println("logger1=" + logger1 + "，name=" + logger1.getName());
        System.out.println("logger1=" + logger1.getParent() + "，name=" + logger1.getParent().getName());
        System.out.println("logger1=" + logger1.getParent().getParent() + "，name=" + logger1.getParent().getParent().getName());
//        System.out.println("logger1="+logger1.getParent().getParent().getParent()+"，name="+logger1.getParent().getParent().getParent().getName());
        System.out.println(logger1.getParent() == logger2);
        System.out.println("logger2的根looger=" + logger2.getParent() + "，name=" + logger2.getParent().getName());


    }


    @Test
    public void test5() throws IOException {
        Logger logger1 = Logger.getLogger("com.java.util.logging");

        Logger logger2 = Logger.getLogger("com.java.util");

        System.out.println("logger1=" + logger1 + "，name=" + logger1.getName());
        System.out.println("logger1=" + logger1.getParent() + "，name=" + logger1.getParent().getName());
        System.out.println("logger1=" + logger1.getParent().getParent() + "，name=" + logger1.getParent().getParent().getName());
//        System.out.println("logger1="+logger1.getParent().getParent().getParent()+"，name="+logger1.getParent().getParent().getParent().getName());
        System.out.println(logger1.getParent() == logger2);
        System.out.println("logger2的根looger=" + logger2.getParent() + "，name=" + logger2.getParent().getName());


    }


    /**
     * 参考 https://blog.csdn.net/cl939974883/article/details/114860381
     *
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        // 使用LogManager的单例来读取该配置文件(与源码读取官方logging.properties方法类似)
//        FileInputStream inputStream = new FileInputStream("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\resources\\com\\java\\util\\logging\\logging.properties");  //注意路径
//
//        Properties properties=new Properties();
//        properties.load(inputStream);


        //使用System来配置文件
        System.setProperty("java.util.logging.config.file", "C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\resources\\com\\java\\util\\logging\\logging.properties");


        Logger logger = Logger.getLogger("com.java.util.logging");

        for (int i = 0; i < 1000000; i++) {
            logger.info("test" + i);
        }


    }


}
