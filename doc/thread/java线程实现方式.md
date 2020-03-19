java线程实现方式

首先，单线程理解为一个人，多线程可以理解为多个人，一般情况下，一项任务分配给多个人要比分配给一个人花费的时间短。所以java的多线程就是为了工作起来更快更省时间。

java线程创建的两种方式

#### 继承Thread类

启动线程的唯一方法就是通过Thread类的start()实例方法，start()方法是一个native方法，它将启动一个新线程，并执行run()方法

如下代码

```java
package com.rookie.bigdata.thread;


/**

 * @author rookie

 * @version 1.0

 * @date 2020/3/19 21:16
   */
   public class MyThread extends Thread {

   private String name;

   public MyThread(String name) {
       this.name = name;
   }

   @Override
   public void run() {
       for (int i = 0; i < 100; i++) {
           System.out.println("执行 " + i + name);
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }

   public static void main(String[] args) {
       MyThread thread1 = new MyThread("thread1");
       thread1.start();

       MyThread thread2 = new MyThread("thread2");
       thread2.start();

   }

}
```

#### 实现Runnable接口

另一种方式就是实现Runnable接口

```java
package com.rookie.bigdata.thread;

/**

 * @author rookie

 * @version 1.0

 * @date 2020/3/19 21:23
   */
   public class MyRunnable implements Runnable {

   private String name;

   public MyRunnable(String name) {
       this.name = name;
   }

   @Override
   public void run() {
       for (int i = 0; i < 100; i++) {
           System.out.println("执行 " + i + name);
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }

   public static void main(String[] args) {
       MyRunnable runnable1 = new MyRunnable("runnable1");
       Thread thread1 = new Thread(runnable1);
       thread1.start();

       MyRunnable runnable2 = new MyRunnable("runnable2");
       Thread thread2 = new Thread(runnable2);
       thread2.start();


    }

}
```

#### 实现Callable接口

实现Callable接口功能要比上面两种类型更强大，如下

```java
package com.rookie.bigdata.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**

 * @author rookie

 * @version 1.0

 * @date 2020/3/19 21:56
   */
   public class MyCallable implements Callable {
   private String name;

   public MyCallable(String name) {
       this.name = name;
   }

   @Override
   public Object call() throws Exception {
       for (int i = 0; i < 100; i++) {
           System.out.println("执行 线程" + i + name);
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       return "task";
   }

   public static void main(String[] args) throws ExecutionException, InterruptedException {
       MyCallable myCallable=new MyCallable("callabe");
       FutureTask futureTask=new FutureTask(myCallable);
       Thread thread=new Thread(futureTask);
       thread.start();

       System.out.println(futureTask.get());
       System.out.println("执行主线程");

   }

}
```

采用实现Callable接口的方式时，如果在启动线程中调用futureTask.get()方法时，启动线程就会等待调用的线程执行完毕以后，启动线程才会往下执行其他的流程。



都是d



都是

都是

都是