package newjava8.streamAPI;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamAPI
 * @Description һ.Stream��������������
 * @Author Langtao
 * @Date 2021/7/4 20:56
 * @Version V1.0
 */

public class StreamAPI {
    public static void main(String[] args) {
        test();
    }
    //����Stream
    public static void test() {
        String[] strings = {"Test", "Stream", "API"};
        List<String> list = Arrays.asList(strings);
        //1.ͨ���������ṩ��Stream()(������)��parallelStream(������)
        Stream<String> stream = list.stream();
        //2.ͨ��Arrays�еľ�̬����Stream()��ȡ������
        Stream<String> stringStream = Arrays.stream(strings);
        //3.ͨ��Stream���еľ�̬����of()
        Stream<String> stringStream1 = Stream.of("Test", "Stream", "API");
        //4.����������
        //a.����
        //���㿪ʼ��ż��ȡ
        Stream.iterate(0,(x)->x+2).limit(10).forEach(System.out::println);
        //b.����
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);

    }
}
