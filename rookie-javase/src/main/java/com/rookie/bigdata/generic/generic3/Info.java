package com.rookie.bigdata.generic.generic3;

/**
 * @Classname Info
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/2 14:13
 * @Version 1.0
 */
interface Info<T>{        // 在接口上定义泛型
    public T getVar() ; // 定义方法，方法的返回值就是泛型类型
}