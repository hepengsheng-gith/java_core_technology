package com.heps.java_core_technology1.interface_test.conflict;

public interface Person {


    default void getName(){
        System.out.println("我是Person中的默认方法");
    }
}
