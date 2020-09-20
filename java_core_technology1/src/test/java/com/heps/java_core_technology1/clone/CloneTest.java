package com.heps.java_core_technology1.clone;

import com.sun.javaws.IconUtil;

import java.util.Objects;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneEntity cloneEntity = new CloneEntity("张三",94);
        System.out.println(cloneEntity);
        Object clone = cloneEntity.clone();
        cloneEntity.getCloneOne().setCloneName("克隆2号");
        cloneEntity.setName("李四");
        System.out.println(cloneEntity);
        System.out.println(clone);


    }

}
