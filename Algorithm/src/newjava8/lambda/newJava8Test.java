package newjava8.lambda;

import java.util.*;
import java.util.function.Consumer;

/**
 * @ClassName newJava8Test
 * @Description TODO
 * @Author Langtao
 * @Date 2021/6/28 23:35
 * @Version V1.0
 */

public class newJava8Test {
    public static void main(String[] args) {
        //�﷨��ʽһ���޲������޷���ֵ
        yufageshi1();
        System.out.println("--------------------------");
        //�﷨��ʽ������һ���������޷���ֵ
        yufageshi2();
        System.out.println("--------------------------");
        //�﷨��ʽ�����ж���������з���ֵ��lambda�����ж������
        System.out.println("--------------------------");
        yufageshi3();
        //���󣺶�һ������������
        System.out.println("--------------------------");
        test();
        //����Ա��
        System.out.println("--------------------------");
        sortEmployee();
        //��������long�͵�ֵ
        System.out.println("----------operationTest-----------");
        operationTest();

    }



    private static void sortEmployee() {
        //��employee���������Ȱ�����������������ͬ����������
        List<Employee> list = Arrays.asList(
                new Employee(10, "����"),
                new Employee(12, "����"),
                new Employee(13, "��һ"),
                new Employee(14, "�ž�"),
                new Employee(9, "����")
        );

        Collections.sort(list,(e1,e2)->{
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
    }


    public static void yufageshi1() {
        //lambda���ʽĬ��Ϊfinal
        int num = 0;

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello lambda!" + num);
            }
        };
        new Thread(runnable1).run();
        System.out.println("--------------------------");
        Runnable runnable2 = () -> System.out.println("hello lambda!" + num);
        new Thread(runnable2).run();
    }

    private static void yufageshi2() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("�Ҳ��ǶԳ��󷽷���ʵ��");
    }


    private static void yufageshi3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("�﷨��ʽ��");
            return Integer.compare(x, y);
        };
    }


    public static void test() {
        Integer opration = opration(100, (x) -> x * 2);
        Integer opration1 = opration(100, (y) -> y * 100);
        Integer opration2 = opration(100, (x) -> x + 2);
        System.out.println(opration);
        System.out.println(opration1);
        System.out.println(opration2);
    }

    public static Integer opration(Integer num, NumberOperation np) {
        return np.getValue(num);
    }

    private static void operationTest() {
        operationLong(100L,
                200L,
                (x, y) -> x + y);
    }


    private static void operationLong(Long l1, Long l2,FanxingInterface<Long,Long> fi) {
        System.out.println(fi.operation(l1, l2));
    }

}
