package com.heps.java_core_technology2.java8_stream;

import jdk.internal.dynalink.linker.LinkerServices;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.rmi.log.LogInputStream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@SpringBootTest
public class StreamTest {

    //1、stream
    //2、parallelStream 并行流 多任务处理


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("gently");
        list.add("down");
        list.add("the");
        list.add("stream");

        long count = list.stream().filter(e -> e.length() > 4).count();
        System.out.println(count);

        long count1 = list.parallelStream().filter(e -> e.length() > 4).count();
        System.out.println(count1);

    }

    @Test
    public void test1() {
        Stream<Double> limit = Stream.generate(Math::random);
        limit.forEach(e -> System.out.println(e));
        System.out.println(limit.count());

    }

    /**
     * stream().limit(n)截取前n个元素
     */
    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        Stream<Integer> limit = list.stream().limit(50);
        limit.forEach(e -> System.out.println(e));
    }

    /**
     * stream().skip(n)跳过前n个元素，留下后面的元素
     */
    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        Stream<Integer> limit = list.stream().skip(50);
        limit.forEach(e -> System.out.println(e));
    }

    /**
     * 1、filte   :流下符合条件的
     * 2、map     :
     * 1、按某种方式转换、处理流中等的值
     * 2、在使用map时，会有一个函数应用到每个元素上，并且其结果是包含了应用该函数后所产生的所有结果的流(嵌套流)
     * 3、flatMap 输入时调用的箭头函数里面有返回值为流的，将其平摊，只返回一个流
     */
    @Test
    public void test5() {
        List<String> list = new ArrayList<>();
        list.add("ANIJRE");
        list.add("BIJIG");
        list.add("CNIA");
        list.add("DIDGJ");
        list.add("EIDG");

        Stream<String> stream = list.stream().map(e -> e.substring(0, 1));
        stream.forEach(e -> System.out.println(e));
    }

    @Test
    public void test6() {
        List<String> words = new ArrayList<>();
        words.add("ANIJRE");
        words.add("BIJIG");
        words.add("CNIA");
        words.add("DIDGJ");
        words.add("EIDG");
        //       Stream<Stream<String>> stream = words.stream().map(e -> codePoints(e));
//        stream.forEach(e-> {
//            e.forEach(a -> System.out.println(a));
//        });
        Stream<String> stream = words.stream().flatMap(e -> codePoints(e));
        stream.forEach(w -> System.out.println(w));

    }

    public static Stream<String> codePoints(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i, j));
            i = j;
        }
        return result.stream();
    }

    /**
     * concat 将俩个流连起来
     */
    @Test
    public void test4() {
        Stream<String> concat = Stream.concat(codePoints("hello"), codePoints("world"));
        concat.forEach(System.out::println);

    }


    /**
     * distinct去重
     */
    @Test
    public void test7() {
        Stream<String> distinct = Stream.of("merryil", "merryil", "merryil", "gently").distinct();
        distinct.forEach(w -> System.out.println(w));
    }

    /**
     * sorted排序
     * 支持构造器
     */
    @Test
    public void test8() {

        List<String> words = new ArrayList<>();
        words.add("gently");
        words.add("merryil");
        words.add("helloword");
        words.add("jiwejdgi");

        Stream<String> sorted = words.stream().sorted();
        sorted.forEach(System.out::println);

        System.out.println("============================");

        Stream<String> sortedLength = words.stream().sorted((a, b) -> {
            return a.length() - b.length();
        });

        sortedLength.forEach(System.out::println);

    }

    /**
     * peek在获取(将这个流转成数组或者集合时)元素时，，都会调用一个函数
     */
    @Test
    public void test9() {
        Object[] objects = Stream.of("gently", "merryil", "helloword", "jiwejdgi").peek(e -> System.out.println("Fetching " + e)).toArray();
//        Object[] objects = Stream.iterate(1, p -> p + 1).peek(e -> System.out.println("Fetching " + e)).limit(20).toArray();
    }


    /**
     * ############################################三、简单约简  #######################################
     * 约简  是一种终结操作，他们会将流约简为可以在程序中使用的非流值
     */
    @Test
    public void test10() {

        //1、max
        //2、min
        //3、findFirst  通常与filter组合使用
        //4、findAny    通常与filter组合使用 并行时很有效
        //5、anyMatch   流中任意元素匹配，不需要filter
        //6、allMatch   流中所有元素匹配，不需要filter
        //7、noneMatch  没有任何元素匹配，不需要filter
        Optional<String> max = Stream.of("gently", "merryil", "helloword", "jiwejdgi").max((a, b) -> a.length() - b.length());
        if (max.isPresent()) {
            System.out.println(max.get());
        }
        Optional<String> min = Stream.of("gently", "merryil", "helloword", "jiwejdgi").min((a, b) -> a.length() - b.length());
        if (min.isPresent()) {
            System.out.println(min.get());
        }
        Optional<String> findFirst = Stream.of("my", "gently", "merryil", "helloword", "jiwejdgi").filter(e -> e.endsWith("y")).findFirst();
        if (findFirst.isPresent()) {
            System.out.println(findFirst.get());
        }
        Optional<String> findAny = Stream.of("gently", "merryil", "helloword", "jiwejdgi", "ijetd").parallel().filter(e -> e.endsWith("d")).findAny();
        System.out.println("*******8" + findAny.orElse("没有"));
        findAny.ifPresent(System.out::println);

        if (findAny.isPresent()) {
            System.out.println(findAny.get());
        }
        boolean b = Stream.of("gently", "merryil", "helloword", "jiwejdgi", "ijetd").parallel().anyMatch(e -> e.endsWith("d"));
        System.out.println(b);
        boolean c = Stream.of("gentlyd", "merryild", "helloword", "jiwejdgid", "ijetd").parallel().allMatch(e -> e.endsWith("d"));
        System.out.println(c);
        boolean d = Stream.of("gently", "merryil", "hellowor", "jiwejdgi", "ijet").parallel().noneMatch(e -> e.endsWith("d"));
        System.out.println(d);
    }


    /**
     * #######################################收集器#####################################################
     */
    @Test
    public void test11() {

        Stream<String> streamArray = Stream.of("ngfjwie", "iosndgo", "isjjd", "ios", "iaso", "ijoa");
        String[] array = streamArray.toArray(String[]::new);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("=========================================================================");
        Stream<String> stream = Stream.of("ngfjwie", "iosndgo", "isjjd", "ios", "iaso", "ijoa");
        List<String> list = stream.collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("=========================================================================");
        Stream<String> streamSet = Stream.of("ngfjwie", "iosndgo", "isjjd", "ios", "iaso", "ijoa");
        Set<String> set = streamSet.collect(toSet());
        set.forEach(System.out::println);

        System.out.println("========================================================================");
        Stream<String> treeSet = Stream.of("ngfjwie", "iosndgo", "isjjd", "ios", "iaso", "ijoa");
        TreeSet<String> collectTreeSet = treeSet.collect(Collectors.toCollection(TreeSet::new));
        collectTreeSet.forEach(System.out::println);

        System.out.println("=========================================================================");
        Stream<String> arrayList = Stream.of("ngfjwie", "iosndgo", "isjjd", "ios", "iaso", "ijoa");
        ArrayList<String> collectArrayList = arrayList.collect(Collectors.toCollection(ArrayList::new));
        collectArrayList.forEach(System.out::println);

        System.out.println("==========================================================================");
        Stream<String> join = Stream.of("ngfjwie", "iosndgo", "isjjd", "ios", "iaso", "ijoa");
        String collect = join.collect(Collectors.joining());
        System.out.println(collect);

        System.out.println("==========================================================================");
        Stream<String> join1 = Stream.of("ngfjwie", "iosndgo", "isjjd", "ios", "iaso", "ijoa");
        String collect1 = join1.collect(Collectors.joining(","));
        System.out.println(collect1);

        System.out.println("===========================================================================");
        Stream<String> summary = Stream.of("ngfjwie", "iosndgo", "isjjd", "ios", "iaso", "ijoa");
        IntSummaryStatistics intSummaryStatistics = summary.collect(Collectors.summarizingInt(String::length));
        System.out.println("平均值 ： " + intSummaryStatistics.getAverage());
        System.out.println("总数 ： " + intSummaryStatistics.getCount());
        System.out.println("最小数： " + intSummaryStatistics.getMin());
        System.out.println("最大数 ： " + intSummaryStatistics.getMax());
        System.out.println("总和 ： " + intSummaryStatistics.getSum());

    }

    @Test
    public void test12() {

        List<Persion> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Persion p = Persion.builder()
                    .id(i)
                    .name("张三" + i)
                    .build();
            list.add(p);
        }
        list.add(Persion.builder().id(0).name("李四").build());

        Map<Integer, Persion> collect = list.stream().collect(
                Collectors.toMap(
                        Persion::getId,
                        Function.identity(),
                        (existingValue, newValue) -> newValue,//{throw new IllegalStateException}
                        TreeMap::new
                ));
        collect.forEach((a, b) -> {
            System.out.println("key : " + a + "     " + "value : " + b);
        });

    }

    @Test
    public void test13() {

        List<Persion> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Persion p = Persion.builder()
                    .id(i)
                    .name("张三" + i)
                    .sex("男")
                    .build();
            list.add(p);
        }

        for (int i = 0; i < 10; i++) {
            Persion p = Persion.builder()
                    .id(i+10)
                    .name("李四"+i)
                    .sex("女")
                    .build();
            list.add(p);
        }
        list.add(Persion.builder().id(0).sex("男").name("李四").build());

        Map<String, List<Persion>> listMap = list.stream().collect(
                Collectors.groupingBy(Persion::getSex)
        );

        listMap.forEach(
                (a,b) ->{
                    System.out.println("key : "+a);
                    b.stream().forEach(System.out::println);
                }
        );
    }

    /**
     * 下游收集器
     */
    @Test
    public void test14(){

        //1、toSet()
        //2、counting()
        //3、summingInt()
        //4、minBy
        //5、maxBy
        //6、collectingAndThen
        //7、mapping
        List<Persion> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Persion p = Persion.builder()
                    .id(i)
                    .name("张三" + i)
                    .sex("男")
                    .build();
            list.add(p);
        }

        for (int i = 0; i < 10; i++) {
            Persion p = Persion.builder()
                    .id(i+10)
                    .name("李四"+i)
                    .sex("女")
                    .build();
            list.add(p);
        }
        list.add(Persion.builder().id(0).sex("男").name("李四").build());

        Map<String, IntSummaryStatistics> listMap = list.stream().collect(
                groupingBy(Persion::getSex, summarizingInt(e -> e.getName().length()))
        );

        listMap.forEach(
                (a,b) ->{
                    System.out.println("key : "+a +"    "+"count: "+b.getSum());
                    System.out.println("key : "+a +"    "+"count: "+b.getMax());
                    System.out.println("key : "+a +"    "+"count: "+b.getMin());
                    System.out.println("key : "+a +"    "+"count: "+b.getMin());
                    System.out.println("key : "+a +"    "+"count: "+b.getMin());
                   // b.stream().forEach(System.out::println);
                }
        );
    }
}
