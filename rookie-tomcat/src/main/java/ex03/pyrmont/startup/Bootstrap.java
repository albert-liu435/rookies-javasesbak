package ex03.pyrmont.startup;

import ex03.pyrmont.connector.http.HttpConnector;

/**
 * @Classname Bootstrap
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/17 16:18
 * @Version 1.0
 */
public class Bootstrap {
    public static void main(String[] args) {
        HttpConnector httpConnector = new HttpConnector();
        //启动应用程序
        httpConnector.start();
    }
}
