package com.heps.java_core_technology1.java_collection.java_collection;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MyLinkedList {


    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        ListIterator<String> listIterator = list.listIterator();
        System.out.println(listIterator.nextIndex());
        listIterator.add("我是第一个元素"  );
        System.out.println(listIterator.nextIndex());
        listIterator.add("我是第二个元素"  );

        listIterator.add("我是第三个元素"  );
        listIterator.add("我是第四个元素"  );
        list.add("我是第五个元素");
        list.forEach(e -> System.out.println(e));
        System.out.println(listIterator.nextIndex());
    }

    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("我是第一个元素" );
        list.add("我是第二个元素" );
        list.add("我是第三个元素" );
        list.add("我是第四个元素" );
        list.add("我是第五个元素" );

        list.remove(2);

        for (String s:list) {
            System.out.println(s.toString());
        }

        System.out.println(list.size());
    }




}
