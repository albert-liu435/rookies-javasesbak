package com.rookie.bigdata;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/21 22:31
 */
public class StringBufferMain {
    public static void main(String[] args) throws Exception{
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10000;j++){
                        stringBuffer.append("a");
                    }
                }
            }).start();
        }

        Thread.sleep(100);
        System.out.println("StringBuilder长度："+stringBuffer.length());
    }
}
