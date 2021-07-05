package newjava8.lambda;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @ClassName methodReference
 * @Description һ.�������ã���Lambda���е������з����Ѿ�ʵ�֣����ǿ���ʹ�á��������á�
 * �������ã���lambda���ʽ������һ�ֱ�����ʽ
 * ��Ҫ�������﷨��ʽ
 * ��.����������
 * ע����õĹ������Ĳ����б�ͺ���ʽ�ӿ��г��󷽷��Ĳ����б���һ��
 * ��.��������
 * @Author Langtao
 * @Date 2021/7/4 18:24
 * @Version V1.0
 */

public class RethodReference {
    //һ.��������
    //1.����::ʵ��������
    public static void test1() {
        PrintStream ps = System.out;
        Consumer<String> tConsumer = (x) -> ps.println(x);
        //����ֱ��д��
        //ǰ�᣺�ӿڵĳ��󷽷�(accept(T t))�Ĳ����б�ͷ���ֵ�����뷽������(println)�Ĳ����б�ͷ���ֵ���ͱ���һ��
        Consumer<String> tConsumer2 = ps::println;

        Employee employee = new Employee();
        Supplier<String> supplier = () -> employee.getName();
        //����ֱ��д��
        Supplier<String> supplier2 = employee::getName;
    }

    //2.��::��̬������
    public static void test2() {
        //compareΪ��̬����
        //ǰ�᣺lambda���еĺ��������б�ͷ���ֵ����Ҫ�ͺ���ʽ�ӿ��г��󷽷��ĺ����б�ͷŻ������ͱ���һ��
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        //��д��
        Comparator<Integer> comparator1 = Integer::compare;
    }

    //3.��::ʵ��������
    public static void test3() {
        //��Lambda �����б��еĵ�һ��������ʵ�������ĵ����ߣ��ڶ���������ʵ�������Ĳ�����ʱ������ʹ������::method��
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        //��
        BiPredicate<String, String> biPredicate1 = String::equals;
    }

    //��.����������
    public static void test4() {
        //�޲ι���
        Supplier<Employee> supplier = () -> new Employee();

        //����������
        //�޲ι���
        Supplier<Employee> supplier1 = Employee::new;
        //�вι���Employee(int age, String name)
        BiFunction<Integer, String, Employee> biFunction = Employee::new;
        Employee employee = biFunction.apply(100, "����");
        System.out.println(employee);
    }

    //��.�������� Type::new
    public static void test5() {
        Function<Integer, String[]> function = (x) -> new String[x];
        String[] strings = function.apply(10);
        System.out.println(strings.length);

        //��д��
        Function<Integer, String[]> function1 = String[]::new;
        String[] strings1 = function1.apply(20);
        System.out.println(strings1.length);
    }
}
