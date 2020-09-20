package com.heps.java_core_technology1.interface_test.compare;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {

    public static void main(String[] args) {
        String[] friends = {"Paul", "Mary", "Peter"};

        LengthComparator lengthComparator = new LengthComparator();


        Arrays.sort(friends, lengthComparator);

        for (String e : friends) {
            System.out.println(e);
        }




    }
}
