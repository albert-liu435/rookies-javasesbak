package com.rookie.bigdata.generic.generic;

/**
 * @Classname GlmapperGeneric
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/2 13:58
 * @Version 1.0
 */
public class GlmapperGeneric<T> {

    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {

    }


    /**
     * 不指定类型
     */
    public void noSpecifyType() {
        GlmapperGeneric generic = new GlmapperGeneric();
        generic.setT("test");
        //需要强制类型转换
        String test = (String) generic.get();
        System.out.println(test);
    }

    /**
     * 指定类型
     */
    public void specifyType() {
        GlmapperGeneric<String> generic = new GlmapperGeneric<>();
        generic.setT("test");
        //不需要强制类型转换
        String test = generic.get();
        System.out.println(test);
    }


}
