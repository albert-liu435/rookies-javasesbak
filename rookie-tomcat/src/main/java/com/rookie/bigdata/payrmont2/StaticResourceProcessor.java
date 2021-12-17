package com.rookie.bigdata.payrmont2;

import java.io.IOException;

/**
 * @Classname StaticResourceProcessor
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/17 11:58
 * @Version 1.0
 */
public class StaticResourceProcessor {


    public void process(Request request,Response response){

        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
