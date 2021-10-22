package com.rookie.bigdata.util.spi;

import org.junit.Test;

import java.util.ServiceLoader;

import static org.junit.Assert.*;

/**
 * @Classname SPIServiceTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/22 10:04
 * @Version 1.0
 */
public class SPIServiceTest {

    @Test
    public void print() {
        ServiceLoader<SPIService> serviceLoader = ServiceLoader.load(SPIService.class);
        SPIService spiService = null;
        for (SPIService service : serviceLoader) {

            service.print("SPI");
        }
    }
}