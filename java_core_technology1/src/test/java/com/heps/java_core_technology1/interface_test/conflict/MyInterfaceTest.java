package com.heps.java_core_technology1.interface_test.conflict;

public class MyInterfaceTest implements Named,Person {

    @Override
    public void getName() {


        Named.super.getName();


        Person.super.getName();
    }
}
