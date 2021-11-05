package com.rookie.bigdata.util.spi;

import org.junit.Test;
import sun.misc.Service;

import java.util.Iterator;
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


    @Test
    public void print2() {


        Iterator<SPIService> providers = Service.providers(SPIService.class);
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

        while (providers.hasNext()) {
            SPIService ser = providers.next();
            ser.print("SPI");
        }
        System.out.println("--------------------------------");
        Iterator<SPIService> iterator = load.iterator();
        while (iterator.hasNext()) {
            SPIService ser = iterator.next();
            ser.print("SPI");
        }
    }

}