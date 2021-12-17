package com.rookie.bigdata.payrmont2;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @Classname ServletProcessor1
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/17 11:59
 * @Version 1.0
 */
public class ServletProcessor1 {


//    public void process(Request request, Response response) {
//
//        String uri = request.getUri();
//
//        int i = uri.lastIndexOf("/" )+1;
//        System.out.println(i);
//
//        String servletName = "com.rookie.bigdata.payrmont2"+uri.substring(uri.lastIndexOf("/")+1);
//
//        URLClassLoader loader = null;
//
//        try {
//            URL[] urls = new URL[1];
//            URLStreamHandler streamHandler = null;
//            File classPah = new File(Constants.WEB_ROOT);
//            String repository = (new URL("file", null, classPah.getCanonicalPath() + File.separator)).toString();
//
//            urls[0] = new URL(null, repository, streamHandler);
//            loader = new URLClassLoader(urls);
//
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        }
//
//        Class myClass = null;
//        try {
//            myClass = loader.loadClass(servletName);
//
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.toString());
//        }
//
//        Servlet servlet = null;
//
//        try {
//            servlet = (Servlet) myClass.newInstance();
//            servlet.service((ServletRequest) request, (ServletResponse) response);
//
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        } catch (Throwable e) {
//            System.out.println(e.toString());
//        }
//
//    }


    public void process(Request request, Response response) {

        String uri = request.getUri();

        int i = uri.lastIndexOf("/" )+1;
        System.out.println(i);

        String servletName = uri.substring(uri.lastIndexOf("/")+1);




        Class myClass = null;
        try {

            if("PrimitiveServlet".equalsIgnoreCase(servletName)){
                //方式三 通过类加载器
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                myClass = contextClassLoader.loadClass("com.rookie.bigdata.payrmont2.PrimitiveServlet");
            }



        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }

        Servlet servlet = null;

        try {
            servlet = (Servlet) myClass.newInstance();
            servlet.service((ServletRequest) request, (ServletResponse) response);

        } catch (Exception e) {
            System.out.println(e.toString());
        } catch (Throwable e) {
            System.out.println(e.toString());
        }

    }
}
