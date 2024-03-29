package newjava8.streamAPI;


import javafx.concurrent.Task;
import newjava8.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

/**
 * @ClassName StreamAPI
 * @Description
 * 一.Stream的三个操作步骤
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作
 * @Author Langtao
 * @Date 2021/7/4 20:56
 * @Version V1.0
 */

public class StreamAPI {
    static List<Employee> list = Arrays.asList(
            new Employee(10, "张三"),
            new Employee(10, "张三"),
            new Employee(10, "张三"),
            new Employee(12, "张五"),
            new Employee(13, "张一"),
            new Employee(14, "张九"),
            new Employee(9, "张七")
    );

    public static void main(String[] args) {
        testMap1();
    }
    //一。创建Stream
    public static void test() {
        String[] strings = {"Test", "Stream", "API"};
        List<String> list = Arrays.asList(strings);
        //1.通过集合所提供的Stream()(串行流)或parallelStream(并行流)
        Stream<String> stream = list.stream();
        //2.通过Arrays中的静态方法Stream()获取数组流
        Stream<String> stringStream = Arrays.stream(strings);
        //3.通过Stream类中的静态方法of()
        Stream<String> stringStream1 = Stream.of("Test", "Stream", "API");
        //4.创建无限流
        //a.迭代
        //从零开始的偶数取
        Stream.iterate(0,(x)->x+2).limit(10).forEach(System.out::println);
        //b.生成
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);

    }
    //二。中间操作：不会执行任何操作
    /**
     * 映射
     * map--接受lambda，将元素转换称以他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
     */
    public static void testMap1() {
        List<String> strings = Arrays.asList("aaa", "bbbb", "dddd");
        strings.stream().map((str) -> str.toUpperCase())
                .forEach(System.out::println);


        list.stream().map((Employee::getName)).forEach(System.out::println);

    }
    public static void testMap2() {
        //map
        List<String> strings = Arrays.asList("aaa", "bbbb", "dddd");
        Stream<Stream<Character>> streamStream = strings.stream().map(StreamAPI::filterStream);
        streamStream.forEach((sm)->{
            sm.forEach(System.out::println);
        });

        //flatMap 将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = strings.stream().flatMap(StreamAPI::filterStream);


    }

    //反例
    public static Stream<Character> filterStream(String string) {
        List<Character> list = new ArrayList<>();
        for (Character character : string.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    /**
     * 筛选与切片
     * filter--接受一个lambda,从流中排除某些元素
     * limit--截断流，使其元素不超过给定数量
     * skip(n)--跳过元素，赶回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流，于limit(n)互补
     * distinct--筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */

    //1.内部迭代：迭代操作由Stream API完成
    //2.外部迭代：集合自己通过迭代器实现
    public static void test1() {
        //filter
        List<Employee> list = Arrays.asList(
                new Employee(10, "张三"),
                new Employee(10, "张三"),
                new Employee(10, "张三"),
                new Employee(12, "张五"),
                new Employee(13, "张一"),
                new Employee(14, "张九"),
                new Employee(9, "张七")
        );
        //得到的是一个流，若没有终止操作则不会打印任何结果
        Stream<Employee> stream = list.stream().filter((x)->x.getAge()<12);
      //三。终止操作：一次性执行全部内容，即"惰性求值"
        stream.forEach(System.out::println);
        System.out.println("====================");
        //limit
        Stream<Employee> stream1 = list.stream();
        stream1.limit(3).forEach(System.out::println);
        System.out.println("====================");
        //skip(n)
        Stream<Employee> skipStream = list.stream();
        skipStream.skip(4).forEach(System.out::println);
        System.out.println("====================");
        //distinct()
        Stream<Employee> distinctStream = list.stream();
        distinctStream.distinct().forEach(System.out::println);
    }

    public static void test2() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                return null;
            }
        };
    }
}
