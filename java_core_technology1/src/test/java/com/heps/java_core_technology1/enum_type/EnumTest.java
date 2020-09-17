package com.heps.java_core_technology1.enum_type;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnumTest {


   public static final Size s= Size.EXTEA_LARGE;

    @Test
    public void test1(){
        System.out.println(s);
    }

    @Test
    public void test2(){
        System.out.println(s);
    }

    @Test
    public void test(){
        float a = 23.32f;

        System.out.println(a/0);
    }



}
