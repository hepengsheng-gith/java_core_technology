package com.heps.java_core_technology1.interface_test.compare;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

}
