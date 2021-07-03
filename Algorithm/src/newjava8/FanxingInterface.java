package newjava8;

/**
 * 声明一个带泛型的函数式接口，泛型类型为<T,R>,T为参数，R为返回值
 */
@FunctionalInterface
public interface FanxingInterface<T,R> {

    public R operation(T t1, T t2);
}
