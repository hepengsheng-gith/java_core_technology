package com.heps.java_core_technology1.java_collection.queue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class JavaQueue {


    public static void main(String[] args) {

        Queue<String> expressLane = new LinkedBlockingDeque<>();

        Queue<List> expressLane1 = new ArrayDeque<>();

        expressLane.add("我是第一个元素");
        expressLane.add("我是第二个元素");
        expressLane.add("我是第三个元素");
        expressLane.add("我是第四个元素");
        expressLane.add("我是第五个元素");

        //1、队列.add()向队列里面添加元素
        //2、对列.element()队列的对头元素
        //3、队列.remove()移除队列中的对头元素
        //4、
        //5、
        //6、
        System.out.println(expressLane);
        System.out.println(expressLane.remove());
        System.out.println(expressLane);
        System.out.println(expressLane.element());
        System.out.println(expressLane.remove("我是第五个元素"));
        System.out.println(expressLane.toString());
        System.out.println(expressLane.poll());
        System.out.println(expressLane.peek());
        System.out.println(expressLane);
        System.out.println(expressLane.offer("我是第六个元素"));
        System.out.println(expressLane);

    }



}
