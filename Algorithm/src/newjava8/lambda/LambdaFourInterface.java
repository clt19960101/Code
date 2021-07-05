package newjava8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName LambdaFourInterface
 * @Description java8内置四大核心函数式接口
 * 1.Consumer<T>:消费型接口 void accept(T t);
 * <p>
 * 2.Supplier<T>:供给型接口 T get();
 * <p>
 * 3.Function<T,R>:函数型接口 R apply<T t>
 * <p>
 * 4.Predicate<T>:断言接口 Boolean test(T t);
 * @Author Langtao
 * @Date 2021/7/1 8:01
 * @Version V1.0
 */

public class LambdaFourInterface {
    public static void main(String[] args) {
        "CDFDS DSFDS".trim();
        //测试供给型接口
        testSupplier();
        //测试函数型接口
        testFunction();
        //测试函数型接口
        testPredicate();

    }


    public static void testSupplier() {
        getNumList(100, ()->(int) (Math.random() * 100)).stream().forEach(System.out::println);
    }

    //供给型接口
    // 需求，产生指定个数的整数，并放入集合中。
    public static List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }


    public static void testFunction() {
        String strHandler = strHandler("\t\t\t 测试函数型 接口", (str) -> str.trim());
        System.out.println(strHandler);
    }

    //函数型接口
    //处理字符串
    public static String strHandler(String str, Function<String, String> stringFunction) {
        return stringFunction.apply(str);
    }


    public static void testPredicate() {
        strPredicate("asdfd", (str) -> str.length() < 3);
    }
    //断言式接口
    //处理字符串
    public static boolean strPredicate(String str, Predicate<String> predicate) {
        return predicate.test(str);
    }
}
