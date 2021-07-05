package newjava8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName LambdaFourInterface
 * @Description java8�����Ĵ���ĺ���ʽ�ӿ�
 * 1.Consumer<T>:�����ͽӿ� void accept(T t);
 * <p>
 * 2.Supplier<T>:�����ͽӿ� T get();
 * <p>
 * 3.Function<T,R>:�����ͽӿ� R apply<T t>
 * <p>
 * 4.Predicate<T>:���Խӿ� Boolean test(T t);
 * @Author Langtao
 * @Date 2021/7/1 8:01
 * @Version V1.0
 */

public class LambdaFourInterface {
    public static void main(String[] args) {
        "CDFDS DSFDS".trim();
        //���Թ����ͽӿ�
        testSupplier();
        //���Ժ����ͽӿ�
        testFunction();
        //���Ժ����ͽӿ�
        testPredicate();

    }


    public static void testSupplier() {
        getNumList(100, ()->(int) (Math.random() * 100)).stream().forEach(System.out::println);
    }

    //�����ͽӿ�
    // ���󣬲���ָ�������������������뼯���С�
    public static List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }


    public static void testFunction() {
        String strHandler = strHandler("\t\t\t ���Ժ����� �ӿ�", (str) -> str.trim());
        System.out.println(strHandler);
    }

    //�����ͽӿ�
    //�����ַ���
    public static String strHandler(String str, Function<String, String> stringFunction) {
        return stringFunction.apply(str);
    }


    public static void testPredicate() {
        strPredicate("asdfd", (str) -> str.length() < 3);
    }
    //����ʽ�ӿ�
    //�����ַ���
    public static boolean strPredicate(String str, Predicate<String> predicate) {
        return predicate.test(str);
    }
}
