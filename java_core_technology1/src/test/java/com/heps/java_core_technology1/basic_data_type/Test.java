package com.heps.java_core_technology1.basic_data_type;

import com.heps.java_core_technology1.enum_type.EnumTest;

public class Test {

    static int d;


    private int a = 2;

    {
        int b = 3;
        System.out.println("对象初始化块执行了" + b);
        System.out.println("属性a的值为" + a);
    }

    static {
        look();
        int c = 4;
        System.out.println("静态初始化块执行了" + c);
        System.out.println(d);
    }

    public Test() {
        System.out.println("构造方法执行了");
        System.out.println(d);
    }

    public static void main(String[] args) {
        BasicDataType v = new BasicDataType();
        EnumTest e = new EnumTest();
    }

    public static void look() {

        System.out.println("静态方法执行了！！");
    }

}
