java8函数式接口 Supplier
函数式接口（Functional Interface）是JDK 8中新增的特性，其实也是lambda表达式编程模式中的一个很重要的构成。我们先看看什么是函数式接口。
函数式接口：有且只有一个抽象方法的接口，为函数式接口。除此限制之外，函数式接口仍然遵循接口的其他基本设计原则，比如允许声明static属性、static方法，也允许有默认方法等
	
Supplier中文翻译就是供应商,对应到java中就是用来提供结果的,其功能类似一个工厂,可以不断的创建对象
Supplier里面只有一个 T get()方法。

其简单用法如下：

```java
//用来获取两个User对象    
Supplier<User> supplier = User::new;
    User user1 = supplier.get();
    user1.setAge(12);
    user1.setName("zhangsan");
    System.out.println(user1);
    System.out.println(supplier.get());
    System.out.println(supplier.get());
```
另一种写法如下：

//返回两个不同的结果

```java
        Supplier<User> supplier1 = () -> new User();
        System.out.println(supplier1.get());
        System.out.println(supplier1.get());
```

```java
    //表示用来返回两个Book对象
    User user = new User();
    Supplier<Book> supplier2 = user::supplier;
    System.out.println(supplier2.get().toString());
    System.out.println(supplier2.get().toString());
```

源码见[github](https://github.com/albert-liu435/rookies-javases/tree/master/rookie-javase-other/src/main/java/com/rookie/bigdata/supplier)