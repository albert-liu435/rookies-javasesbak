package com.rookie.bigdata.spi;


import org.junit.Test;

import java.util.ServiceLoader;


/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/27 21:45
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
