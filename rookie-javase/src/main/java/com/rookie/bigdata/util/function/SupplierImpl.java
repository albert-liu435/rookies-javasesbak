package com.rookie.bigdata.util.function;

import java.util.function.Supplier;

/**
 * @Classname SupplierImpl
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/22 17:22
 * @Version 1.0
 */
public class SupplierImpl implements Supplier<User> {


    @Override
    public User get() {


        return new User();
    }
}
