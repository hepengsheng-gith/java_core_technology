package com.heps.java_core_technology1.interface_test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FlyTest {

    public static void main(String[] args) {
        BirdFly fly = new BirdFly();
        Aircraft fly1 = new Aircraft();

        Fly a = (Fly) fly;
        Fly b = (Fly) fly1;


        a.bird();
        b.bird();
        Fly.test1();
        Fly.test2();

        System.out.println(Fly.name);

        System.out.println(a.defaultVoid());

        System.out.println(b.mydefault());
    }

}
