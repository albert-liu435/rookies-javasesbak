package com.rookie.bigdata.prototype;

/**
 * @ClassName ShallowAttachment
 * @Description 附件类
 * @Author rookie
 * @Date 2020/6/19 11:04
 * @Version 1.0
 */
public class ShallowAttachment {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download() {
        System.out.println("下载附件" + name);
    }
}
