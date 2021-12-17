package ex03.pyrmont.connector.http;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname PrimitiveServlet
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/17 10:59
 * @Version 1.0
 */
public class PrimitiveServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {


        String errorMessage = "HTTP/1.1 200 Hello. Roses are red.\r\n" + "Content-Type: text/html\r\n" + "Content-Length: 21\r\n" + "\r\n" + "<h1>Hello. Roses are red.</h1>";

        System.out.println("from service");
        PrintWriter out = response.getWriter();
        out.println(errorMessage);
        //  out.println("Violets are blue");
        // out.flush();


//        ServletOutputStream output = response.getOutputStream();
//        // file not found
//        String errorMessage = "HTTP/1.1 200 Hello. Roses are red.\r\n" + "Content-Type: text/html\r\n" + "Content-Length: 21\r\n" + "\r\n" + "<h1>Hello. Roses are red.</h1>";
//        output.write(errorMessage.getBytes());

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
