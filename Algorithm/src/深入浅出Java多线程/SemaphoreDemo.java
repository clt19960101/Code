package ����ǳ��Java���߳�;

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
                System.out.println(String.format("��ǰ�߳���%d,��ʣ%d����Դ����ʣ%d���߳��ڵȴ�", value, semaphore.availablePermits(), semaphore.getQueueLength()));
                //���˯��ʱ��
                Random random = new Random();
                Thread.sleep(random.nextInt(1000));
                System.out.println(String.format("�߳�%d�ͷ�����Դ", value));
            } catch (Exception e) {
                e.printStackTrace();

            }finally {
                semaphore.release();
            }

        }
    }

}
