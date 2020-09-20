package com.heps.java_core_technology1.interface_test.compare;

import java.util.Arrays;

public class PersonAndAnimalTest {


    public static void main(String[] args) {
        Comparable[] comparables = new Comparable[3];
        comparables[0] = new Persion(78);
        comparables[1] = new Animal(69);
        comparables[2] = new Persion(50);

        Arrays.sort(comparables);

        for (Comparable comparable: comparables) {
            System.out.println(comparable);
        }

    }


}
