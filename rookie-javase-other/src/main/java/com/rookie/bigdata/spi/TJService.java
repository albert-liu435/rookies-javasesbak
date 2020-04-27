package com.rookie.bigdata.spi;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/27 21:41
 */
public class TJService implements SPIService {
    @Override
    public void print(String msg) {
        System.out.println("天津市");
    }
}

