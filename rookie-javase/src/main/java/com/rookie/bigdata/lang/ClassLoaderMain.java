package com.rookie.bigdata.lang;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/8 7:30
 */
public class ClassLoaderMain {

    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

//当前的ClassLoader是AppClassLoder，其父ClassLoader是ExtClassLoader，祖父ClassLoader是根类装载器。java无法获取它的句柄，所以返回是null
        System.out.println("1  "+contextClassLoader);
        System.out.println("2  "+contextClassLoader.getParent());
        System.out.println("3  "+contextClassLoader.getParent().getParent());
    }

}
