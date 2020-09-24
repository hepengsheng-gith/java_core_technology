package com.heps.java_core_technology1.java_thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 执行器
 * 有许多静态方法用来构造线程池
 */
public class ExecutorsTest {

    /**
     * newCachedThreadPool()方法构一个、线程池，会立即执行各个任务，
     * 如果有空闲线程可用，就使用空闲线程执行任务
     * 如果没有可用的空闲线程，则创建一个新线程。
     */
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    /**
     * newFixedThreadPool方法构造一个具有固定大小的线程池。
     * 如果提交的任务数多于空闲线程数，就把未得到的服务的任务放到队列中。
     * 当其他任务完成以后在运行这些排队的任务
     *
     */
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {



//        new ExecutorsTest().cachedThreadPoolTest();
        new ExecutorsTest().fixedThreadPoolTest();


    }

    public void cachedThreadPoolTest() {

        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(Thread.currentThread());
                System.out.println(i);
            }
        };

        this.cachedThreadPool.submit(runnable);
    }

    public void fixedThreadPoolTest(){
        Runnable runnable = () -> {
            for (int i = 0; i < 1000000; i++) {
                System.out.println(Thread.currentThread());
                System.out.println(i);
            }
        };

        this.fixedThreadPool.submit(runnable);
    }


}
