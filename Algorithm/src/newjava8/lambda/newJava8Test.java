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
        //语法格式一：无参数，无返回值
        yufageshi1();
        System.out.println("--------------------------");
        //语法格式二：有一个参数，无返回值
        yufageshi2();
        System.out.println("--------------------------");
        //语法格式三：有多个参数，有返回值且lambda体中有多条语句
        System.out.println("--------------------------");
        yufageshi3();
        //需求：对一个数进行运算
        System.out.println("--------------------------");
        test();
        //排序员工
        System.out.println("--------------------------");
        sortEmployee();
        //计算两个long型的值
        System.out.println("----------operationTest-----------");
        operationTest();

    }



    private static void sortEmployee() {
        //对employee进行排序，先按年龄排序，若年龄相同则按姓名排序
        List<Employee> list = Arrays.asList(
                new Employee(10, "张三"),
                new Employee(12, "张五"),
                new Employee(13, "张一"),
                new Employee(14, "张九"),
                new Employee(9, "张七")
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
        //lambda表达式默认为final
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
        consumer.accept("右侧是对抽象方法的实现");
    }


    private static void yufageshi3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("语法格式三");
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
