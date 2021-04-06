package ThreadLocalDemo;

import java.lang.reflect.Field;

/**
 * @ClassName ThreadLocalDemo
 * @Description TODO
 * @Author Langtao
 * @Date 2021/4/3 10:55
 * @Version V1.0
 */

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->test("abc",false));
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();

    }
    private static void test(String s,boolean isGC){
        try {
            new ThreadLocal<>().set(s);
            if (isGC) {
                System.gc();
            }
            //当前线程
            Thread thread = Thread.currentThread();
            //反射
            Class<? extends Thread> clz = thread.getClass();
            //得到ThreadLocalMap类型threadLocals对象
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(thread);

            Class<?> tlmClass = threadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(threadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
