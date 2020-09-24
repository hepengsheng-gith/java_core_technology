package com.heps.java_core_technology1.java_thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

    public static void main(String[] args) {

//        Runnable task1 = () -> {
//            List<String> list1 = new ArrayList<>();
//            list1.add("我是task1的第一个元素");
//            list1.add("我是task1的第二个元素");
//            list1.add("我是task1的第三个元素");
//            list1.add("我是task1的第四个元素");
//            list1.add("我是task1的第五个元素");
//
//            list1.forEach(e -> System.out.println(e));
//
//        };
//
//        Runnable task2 = () -> {
//            List<String> list1 = new ArrayList<>();
//            list1.add("我是task2的第一个元素");
//            list1.add("我是task2的第二个元素");
//            list1.add("我是task2的第三个元素");
//            list1.add("我是task2的第四个元素");
//            list1.add("我是task2的第五个元素");
//
//            list1.forEach(e -> System.out.println(e));
//        };
//
//        new Thread(task1).start();
//        new Thread(task2).start();

        Thread thread1 = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("我是task1的第一个元素");
            list1.add("我是task1的第二个元素");
            list1.add("我是task1的第三个元素");
            list1.add("我是task1的第四个元素");
            list1.add("我是task1的第五个元素");

            list1.forEach(e -> System.out.println(e));
        });
        System.out.println(thread1.getState());
        thread1.start();
        System.out.println(thread1.getState());


        new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("我是task2的第一个元素");
            list1.add("我是task2的第二个元素");
            list1.add("我是task2的第三个元素");
            list1.add("我是task2的第四个元素");
            list1.add("我是task2的第五个元素");

            list1.forEach(e -> System.out.println(e));
        }).start();


    }
}
