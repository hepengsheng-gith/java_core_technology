package com.heps.java_core_technology1.lambda;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootTest
public class lambdaTestOne {

    private static final Logger myLogger = Logger.getLogger("com.heps.java_core_technology1.lambda.lambdaTestOne");

    /**
     * 为什么引入lambda表达式
     * lambda表达式是一个可传递的代码块，可以在以后执行一次或多次
     */
    @Test
    public void test1() {
        System.out.println("我是中国人");
    }

    @Test
    public void test2() {
        myLogger.info("日志类");
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sort by length");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));
    }

}
