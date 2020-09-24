package com.heps.java_core_technology1.java_collection.java_collection;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("我是第一个元素");
        list.add("我是第二个元素");
        list.add("我是第三个元素");
        list.add("我是第四个元素");
        list.forEach(element -> {System.out.println(element);});
        list.iterator().forEachRemaining(element -> System.out.println(element));
    }
}
