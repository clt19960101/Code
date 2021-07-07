package newjava8.streamAPI;


import newjava8.Employee;

import java.util.Arrays;
import java.util.List;
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
    public static void main(String[] args) {
        test();
        test1();
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
    //�м����������ִ���κβ���

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
      //��ֹ������һ����ִ��ȫ�����ݣ���"������ֵ"
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

    }
}
