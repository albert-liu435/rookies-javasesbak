package com.rookie.bigdata.util.function;

import java.util.function.Function;

/**
 * @Classname MyFunction
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/25 17:52
 * @Version 1.0
 */
public class MyFunction<T, R> {

    public Function<T, R> getProcessor() {
        return processor;
    }

    public void setProcessor(Function<T, R> processor) {
        this.processor = processor;
    }

    private Function<T, R> processor = new Function<T, R>() {
        @Override
        public R apply(T t) {
            return (R) new String( t+" : MyFunction");

        }
    };

}
