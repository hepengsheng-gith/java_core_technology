package com.heps.java_core_technology1.java_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () ->{
            for (int i=0;i<100;i++){
                System.out.println(i);
            }
            return 200;
        };

        FutureTask<Integer> futureTask = new FutureTask(task);

        Thread thread = new Thread(futureTask);
        thread.start();

        Integer integer = futureTask.get();
        System.out.println(integer);

    }
}
