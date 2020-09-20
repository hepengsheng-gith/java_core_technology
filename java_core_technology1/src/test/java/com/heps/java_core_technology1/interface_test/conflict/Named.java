package com.heps.java_core_technology1.interface_test.conflict;

public interface Named {

    default void getName(){
        System.out.println("我是Named中的默认方法");
    }

}
