package com.rookie.bigdata.prototype;

import java.io.*;

/**
 * @ClassName DeepWeeklyLog
 * @Description DeepWeeklyLog
 * @Author liuxili
 * @Date 2020/6/19 11:12
 * @Version 1.0
 */
public class DeepWeeklyLog implements Serializable {

    private DeepAttachment attachment;
    private String date;
    private String name;
    private String content;

    public DeepAttachment getAttachment() {
        return attachment;
    }

    public void setAttachment(DeepAttachment attachment) {
        this.attachment = attachment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    //通过序列化进行深克隆
    public DeepWeeklyLog deepclone() throws Exception {
        //将对象写入流中,
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);
        //将对象取出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bi);
        return (DeepWeeklyLog) ois.readObject();


    }

}
