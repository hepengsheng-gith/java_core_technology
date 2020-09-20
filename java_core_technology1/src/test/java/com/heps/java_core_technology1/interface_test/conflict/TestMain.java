package com.heps.java_core_technology1.interface_test.conflict;

public class TestMain {

    public static void main(String[] args) {
        MyFatherTest myFatherTest = new MyFatherTest();

        myFatherTest.getName();

        MyInterfaceTest myInterfaceTest = new MyInterfaceTest();
        myInterfaceTest.getName();

    }

}
