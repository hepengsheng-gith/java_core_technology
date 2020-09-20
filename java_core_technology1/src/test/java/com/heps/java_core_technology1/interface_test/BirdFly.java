package com.heps.java_core_technology1.interface_test;

public class BirdFly implements Fly {



    @Override
    public void bird() {

        System.out.println("name= "+name+"我是鸟，我正在飞");
    }

    @Override
    public int defaultVoid() {
        System.out.println("我是鸟，我重写了Fly接口中的默认方法");
        return 0;
    }
}
