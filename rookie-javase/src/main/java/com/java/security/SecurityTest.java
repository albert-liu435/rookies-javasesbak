package com.java.security;

/**
 * @Classname SecurityTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/27 9:47
 * @Version 1.0
 */
public class SecurityTest {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        System.getSecurityManager().checkRead("foo.txt");
    }
}
