package com.heps.java_core_technology1.extends_test;

import java.util.Objects;

public class Manger extends Employee {

    int c = 30;

    int d = 4;

    String e = "我是中国人";

    public int getSum(){

        return  super.getSum() + c;
    }


    public static void main(String[] args) {
        Manger manger1 = new Manger();
        manger1.setA(10);
        manger1.setB(20);
        Manger manger2 = new Manger();
        manger2.setA(10);
        manger2.setB(20);

        Manger manger3 = manger1;
        System.out.println( manger1.equals(manger2));

        System.out.println(manger1.hashCode());
        System.out.println(manger2.hashCode());
        System.out.println(manger3.hashCode());

        System.out.println(manger1.toString());
        System.out.println(manger2.toString());
        System.out.println(manger3.toString());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manger manger = (Manger) o;
        return c == manger.c &&
                d == manger.d &&
                e.equals(manger.e)
                && super.getA() == manger.getA() && super.getB() == manger.getB();

    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(c, d, e,super.getA(),super.getB());
//    }
}
