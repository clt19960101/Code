package ThreadCode.PrintABC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicInteger_PrintABC
 * @Description ����
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
                    System.out.println("�߳�A");
                    atomicInteger.incrementAndGet();
                }
            }
        });
        Thread B = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (atomicInteger.intValue() % 3 == 1) {
                    System.out.println("�߳�B");
                }
            }
        });
        Thread C = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (atomicInteger.intValue() % 3 == 2) {
                    System.out.println("�߳�C");
                }
            }
        });


        A.start();
        B.start();
        C.start();
    }
}
