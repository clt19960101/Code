package newjava8.lambda;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @ClassName methodReference
 * @Description 一.方法引用：若Lambda体中的内容有方法已经实现，我们可以使用“方法引用”
 * 方法引用：即lambda表达式的另外一种表现形式
 * 主要有三种语法格式
 * 二.构造器引用
 * 注意调用的构造器的参数列表和函数式接口中抽象方法的参数列表保持一致
 * 三.数组引用
 * @Author Langtao
 * @Date 2021/7/4 18:24
 * @Version V1.0
 */

public class RethodReference {
    //一.方法引用
    //1.对象::实例方法名
    public static void test1() {
        PrintStream ps = System.out;
        Consumer<String> tConsumer = (x) -> ps.println(x);
        //可以直接写成
        //前提：接口的抽象方法(accept(T t))的参数列表和返回值类型与方法引用(println)的参数列表和返回值类型保持一致
        Consumer<String> tConsumer2 = ps::println;

        Employee employee = new Employee();
        Supplier<String> supplier = () -> employee.getName();
        //可以直接写成
        Supplier<String> supplier2 = employee::getName;
    }

    //2.类::静态方法名
    public static void test2() {
        //compare为静态方法
        //前提：lambda体中的函数参数列表和返回值类型要和函数式接口中抽象方法的函数列表和放回置类型保持一致
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        //改写成
        Comparator<Integer> comparator1 = Integer::compare;
    }

    //3.类::实例方法名
    public static void test3() {
        //若Lambda 参数列表中的第一个参数是实例方法的调用者，第二个参数是实例方法的参与者时，可以使用类名::method名
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        //即
        BiPredicate<String, String> biPredicate1 = String::equals;
    }

    //二.构造器引用
    public static void test4() {
        //无参构造
        Supplier<Employee> supplier = () -> new Employee();

        //构造器引用
        //无参构造
        Supplier<Employee> supplier1 = Employee::new;
        //有参构造Employee(int age, String name)
        BiFunction<Integer, String, Employee> biFunction = Employee::new;
        Employee employee = biFunction.apply(100, "张三");
        System.out.println(employee);
    }

    //三.数组引用 Type::new
    public static void test5() {
        Function<Integer, String[]> function = (x) -> new String[x];
        String[] strings = function.apply(10);
        System.out.println(strings.length);

        //改写成
        Function<Integer, String[]> function1 = String[]::new;
        String[] strings1 = function1.apply(20);
        System.out.println(strings1.length);
    }
}
