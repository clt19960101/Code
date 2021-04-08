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
        System.out.println("--gc��--");
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
            //��ǰ�߳�
            Thread thread = Thread.currentThread();
            //����
            Class<? extends Thread> clz = thread.getClass();
            //�õ�ThreadLocalMap����threadLocals����
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
                    System.out.println(String.format("������key:%s,ֵ:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
