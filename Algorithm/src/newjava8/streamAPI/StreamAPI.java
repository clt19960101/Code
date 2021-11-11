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
 * һ.Stream��������������
 * 1.����Stream
 * 2.�м����
 * 3.��ֹ����
 * @Author Langtao
 * @Date 2021/7/4 20:56
 * @Version V1.0
 */

public class StreamAPI {
    static List<Employee> list = Arrays.asList(
            new Employee(10, "����"),
            new Employee(10, "����"),
            new Employee(10, "����"),
            new Employee(12, "����"),
            new Employee(13, "��һ"),
            new Employee(14, "�ž�"),
            new Employee(9, "����")
    );

    public static void main(String[] args) {
        testMap1();
    }
    //һ������Stream
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
    //�����м����������ִ���κβ���
    /**
     * ӳ��
     * map--����lambda����Ԫ��ת����������ʽ����ȡ��Ϣ������һ��������Ϊ�������ú����ᱻӦ�õ�ÿ��Ԫ���ϣ�������ӳ���һ���µ�Ԫ�ء�
     * flatMap--����һ��������Ϊ�����������е�ÿ��ֵ��������һ������Ȼ������������ӳ�һ������
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

        //flatMap �����е�ÿ��ֵ��������һ������Ȼ������������ӳ�һ������
        Stream<Character> characterStream = strings.stream().flatMap(StreamAPI::filterStream);


    }

    //����
    public static Stream<Character> filterStream(String string) {
        List<Character> list = new ArrayList<>();
        for (Character character : string.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    /**
     * ɸѡ����Ƭ
     * filter--����һ��lambda,�������ų�ĳЩԪ��
     * limit--�ض�����ʹ��Ԫ�ز�������������
     * skip(n)--����Ԫ�أ��ϻ�һ���ӵ���ǰn��Ԫ�ص�����������Ԫ�ز���n�����򷵻�һ����������limit(n)����
     * distinct--ɸѡ��ͨ����������Ԫ�ص�hashCode()��equals()ȥ���ظ�Ԫ��
     */

    //1.�ڲ�����������������Stream API���
    //2.�ⲿ�����������Լ�ͨ��������ʵ��
    public static void test1() {
        //filter
        List<Employee> list = Arrays.asList(
                new Employee(10, "����"),
                new Employee(10, "����"),
                new Employee(10, "����"),
                new Employee(12, "����"),
                new Employee(13, "��һ"),
                new Employee(14, "�ž�"),
                new Employee(9, "����")
        );
        //�õ�����һ��������û����ֹ�����򲻻��ӡ�κν��
        Stream<Employee> stream = list.stream().filter((x)->x.getAge()<12);
      //������ֹ������һ����ִ��ȫ�����ݣ���"������ֵ"
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
