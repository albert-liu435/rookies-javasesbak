package ex03.pyrmont;

import com.rookie.bigdata.payrmont2.Request;
import com.rookie.bigdata.payrmont2.RequestFacade;
import com.rookie.bigdata.payrmont2.Response;
import com.rookie.bigdata.payrmont2.ResponseFacade;
import ex03.pyrmont.connector.http.Constants;
import ex03.pyrmont.connector.http.HttpRequest;
import ex03.pyrmont.connector.http.HttpResponse;
import ex03.pyrmont.connector.http.HttpRequestFacade;
import ex03.pyrmont.connector.http.HttpResponseFacade;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor {


    public void process(HttpRequest request, HttpResponse response) {

        String uri = request.getRequestURI();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {
            // create a URLClassLoader
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
//        Class myClass = null;
//        try {
//            myClass = loader.loadClass(servletName);
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.toString());
//        }
//
//        Servlet servlet = null;
//
//        try {
//            servlet = (Servlet) myClass.newInstance();
//            HttpRequestFacade requestFacade = new HttpRequestFacade(request);
//            HttpResponseFacade responseFacade = new HttpResponseFacade(response);
//            servlet.service(requestFacade, responseFacade);
//            ((HttpResponse) response).finishResponse();
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        } catch (Throwable e) {
//            System.out.println(e.toString());

        Class myClass = null;
        try {

            if ("PrimitiveServlet".equalsIgnoreCase(servletName)) {
                //方式三 通过类加载器
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                myClass = contextClassLoader.loadClass("com.rookie.bigdata.payrmont2.PrimitiveServlet");
            }


        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }

        Servlet servlet = null;

        RequestFacade requestFacade = new RequestFacade(request);
        ResponseFacade responseFacade = new ResponseFacade(response);
        try {
            servlet = (Servlet) myClass.newInstance();
            servlet.service(requestFacade, responseFacade);

            ((HttpResponse) response).finishResponse();
        } catch (Exception e) {
            System.out.println(e.toString());
        } catch (Throwable e) {
            System.out.println(e.toString());
        }


    }
}


//    public void process(HttpRequest request, HttpResponse response) {
//
//        String uri = request.getRequestURI();
//
//        int i = uri.lastIndexOf("/") + 1;
//        System.out.println(i);
//
//        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
//
//
//        Class myClass = null;
//        try {
//
//            if ("PrimitiveServlet".equalsIgnoreCase(servletName)) {
//                //方式三 通过类加载器
//                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//                myClass = contextClassLoader.loadClass("com.rookie.bigdata.payrmont2.PrimitiveServlet");
//            }
//
//
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.toString());
//        }
//
//        Servlet servlet = null;
//
//        RequestFacade requestFacade = new RequestFacade(request);
//        ResponseFacade responseFacade = new ResponseFacade(response);
//        try {
//            servlet = (Servlet) myClass.newInstance();
//            servlet.service((ServletRequest) requestFacade, (ServletResponse) responseFacade);
//
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        } catch (Throwable e) {
//            System.out.println(e.toString());
//        }
//
//    }
//}