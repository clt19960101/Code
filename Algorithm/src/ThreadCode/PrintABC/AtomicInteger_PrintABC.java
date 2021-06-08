package ThreadCode.PrintABC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicInteger_PrintABC
 * @Description 错误
 * @Author Langtao
 * @Date 2021/5/13 23:54
 * @Version V1.0
 */

public class AtomicInteger_PrintABC {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int index=0;
        Thread A = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (atomicInteger.intValue() % 3 == 0) {
                    System.out.println("线程A");
                    atomicInteger.incrementAndGet();
                }
            }
        });
        Thread B = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (atomicInteger.intValue() % 3 == 1) {
                    System.out.println("线程B");
                }
            }
        });
        Thread C = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (atomicInteger.intValue() % 3 == 2) {
                    System.out.println("线程C");
                }
            }
        });


        A.start();
        B.start();
        C.start();
    }
}
