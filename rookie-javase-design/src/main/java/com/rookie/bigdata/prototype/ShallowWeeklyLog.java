package com.rookie.bigdata.prototype;

/**
 * @ClassName ShallowWeeklyLog
 * @Description 周报类充当具体的原型类
 * @Author rookie
 * @Date 2020/6/19 11:06
 * @Version 1.0
 */
public class ShallowWeeklyLog implements Cloneable {
    private ShallowAttachment attachment;
    private String date;
    private String name;
    private String content;

    public ShallowAttachment getAttachment() {
        return attachment;
    }

    public void setAttachment(ShallowAttachment attachment) {
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


    //实现clone()方法实现浅克隆
    public ShallowWeeklyLog clone() {
        //需要实现cloneable的接口，直接继承object就好，它里面自带一个clone方法！
        Object obj = null;
        try {
            obj = super.clone();
            return (ShallowWeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            System.out.println("不支持克隆方法！");
            return null;
        }


    }
}
