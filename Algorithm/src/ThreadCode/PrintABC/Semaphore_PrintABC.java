package ThreadCode.PrintABC;

import java.util.concurrent.Semaphore;

/**
 * @ClassName Synchronized_PrintABC
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/19 21:10
 * @Version V1.0
 */

public class Semaphore_PrintABC {
    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreA.acquire();
                    System.out.println("线程A");
                    semaphoreB.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreB.acquire();
                    System.out.println("线程B");
                    semaphoreC.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreC.acquire();
                    System.out.println("线程C");
                    semaphoreA.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
