package com.heps.java_core_technology1.basic_data_type;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BasicDataType {

    /**
     * byte类型为有符号位，调用Byte.toUsignedInt()来得到一个0-255的一个Int值
     */
    @Test
    public void test1() {
        byte a = (byte) 0x96;
        System.out.println(a);
        int i = Byte.toUnsignedInt(a);
        System.out.println(i);
    }

    @Test
    public void test2() {
        byte b = (byte) 254;
        System.out.println(b);
        int i = Byte.toUnsignedInt(b);
        System.out.println(i);

    }

    @Test
    public void test3() {
        int a = 0xAF;
        int b = 0b100;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 浮点类型
     */
    @Test
    public void test4() {
        double a = Double.POSITIVE_INFINITY;//正无群大
        double b = Double.NEGATIVE_INFINITY;//负无群大
        double c = Double.NaN;//不是一个数字
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    @Test
    public void test5() {
        double a = -324.98;
        System.out.println(a / 0);
    }

    /**
     * 位运算
     * 1、&：与运算符
     * 2、|：或运算符
     * 3、~：非运算符
     * 4、^:异或运算符
     * 5、>>:右移运算符
     * 6、<<:左移运算符
     * 7、>>>:无符号右移运算符
     */
    @Test
    public void test6() {

        int a = -5;
        int b = 4;
        //&
        //  -5的二进制形式为：11111111 11111111 11111111 11111011
        //
        //    4的二进制形式为：00000000 00000000 00000000 00000100
        //
        //    进行逻辑运算后为：00000000 00000000 00000000 00000000
        //
        //    转换为十进制为：0
        System.out.println(a & b);
//        -5的二进制形式为：11111111 11111111 11111111 11111011
//
//        4的二进制形式为：00000000 00000000 00000000 00000100
//
//        进行逻辑运算后为：11111111 11111111 11111111 11111111
//
//        转换为十进制为：-1
        System.out.println(a | b);
//        -5的二进制形式为：11111111 11111111 11111111 11111011
//
//        取反后的二进制形式为：00000000 00000000 00000000 00000100
//
//        转换为十进制为：4
        System.out.println(~a);
//        -5的二进制形式为：11111111 11111111 11111111 11111011
//
//        4的二进制形式为：00000000 00000000 00000000 00000100
//
//        进行逻辑运算后为：11111111 11111111 11111111 11111111
//
//        转换为十进制为：-1
        System.out.println(a ^ b);

//      m << n    m的值乘以2的n次幂，需在类型有效范围内，超出范围的部分舍弃
        System.out.println(b << 2);
//      m >> n    m的值除以2的n次幂，需在类型有效范围内，超出范围的部分舍弃
        System.out.println(b >> 2);

        System.out.println(a >> 4);
        System.out.println(b >> 4);
    }

    @Test
    public void test7() {
        byte a = 4;
        System.out.println(a<<29);
    }


}
