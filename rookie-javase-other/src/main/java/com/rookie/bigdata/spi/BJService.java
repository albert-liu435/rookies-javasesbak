package com.rookie.bigdata.spi;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/27 21:42
 */
public class BJService implements SPIService {
    @Override
    public void print(String msg) {
        System.out.println("北京市");
    }
}
