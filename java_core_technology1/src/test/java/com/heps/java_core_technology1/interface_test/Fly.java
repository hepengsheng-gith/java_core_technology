package com.heps.java_core_technology1.interface_test;

public interface Fly {

    String name = "我不是人";

    void bird();

    public static void test1(){
        System.out.println("我是静态方法，test1");
    }

    public static void test2(){
        System.out.println("我是静态方法，test2");
    }

    default int defaultVoid(){
        return 0;
    }

    default int mydefault(){
        return 1;
    }
}
