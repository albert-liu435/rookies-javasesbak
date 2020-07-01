package com.rookie.bigdata.prototype;

import java.io.Serializable;

/**
 * @ClassName DeepAttachment
 * @Description DeepAttachment
 * @Author liuxili
 * @Date 2020/6/19 11:11
 * @Version 1.0
 */
public class DeepAttachment implements Serializable {

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
