package newjava8;

/**
 * ����һ�������͵ĺ���ʽ�ӿڣ���������Ϊ<T,R>,TΪ������RΪ����ֵ
 */
@FunctionalInterface
public interface FanxingInterface<T,R> {

    public R operation(T t1, T t2);
}
