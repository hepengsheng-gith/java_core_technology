package com.heps.java_core_technology1.generic_paradigm;

import java.util.Collection;

public class ArrayAlg {

    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }

    public void test(){

    }

    public <T> T test1(T a){

        return a;
    }

}
