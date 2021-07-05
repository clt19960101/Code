package newjava8.streamAPI;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamAPI
 * @Description 一.Stream的三个操作步骤
 * @Author Langtao
 * @Date 2021/7/4 20:56
 * @Version V1.0
 */

public class StreamAPI {
    public static void main(String[] args) {
        test();
    }
    //创建Stream
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
}
