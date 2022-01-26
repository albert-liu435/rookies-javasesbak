package com.java.lang.reflect.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname Foo
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/17 11:39
 * @Version 1.0
 */
public class Foo implements FooInterface{
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public static void main(String ...args) {
        InvocationHandler handler = new InvocationHandler() {
            private FooInterface foo = new Foo();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getDeclaringClass().equals(FooInterface.class)) {
                    if ("getName".equals(method.getName())) {
                        System.out.println("get name through proxy");
                    }
                    else if ("setName".equals(method.getName())) {
                        System.out.println("set name through proxy");
                    }
                    return method.invoke(foo, args);
                }
                return method.invoke(foo, args);
            }
        };

        Class<?> fooProxy = Proxy.getProxyClass(Foo.class.getClassLoader(), FooInterface.class);
        try {
            FooInterface foo = (FooInterface) fooProxy.getConstructor(InvocationHandler.class).newInstance(handler);
            foo.setName("name");
            System.out.println(foo.getName());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
