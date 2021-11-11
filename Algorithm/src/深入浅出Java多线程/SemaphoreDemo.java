package 深入浅出Java多线程;

import com.sun.javafx.binding.StringFormatter;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreDemo
 * @Author Chen Langtao
 * @Date 2021/11/4 23:23
 * @Description TODO
 * @Version 1.0
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread(i, semaphore)).start();
        }
    }

    static class MyThread implements Runnable {
        private int value;
        private Semaphore semaphore;

        public MyThread(int value, Semaphore semaphore) {
            this.value = value;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(String.format("当前线程是%d,还剩%d个资源，还剩%d个线程在等待", value, semaphore.availablePermits(), semaphore.getQueueLength()));
                //随机睡眠时间
                Random random = new Random();
                Thread.sleep(random.nextInt(1000));
                System.out.println(String.format("线程%d释放了资源", value));
            } catch (Exception e) {
                e.printStackTrace();

            }finally {
                semaphore.release();
            }

        }
    }

}
