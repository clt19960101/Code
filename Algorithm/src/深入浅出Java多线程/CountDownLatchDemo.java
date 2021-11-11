package ����ǳ��Java���߳�;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchDemo
 * @Author Chen Langtao
 * @Date 2021/11/7 13:55
 * @Description TODO
 * @Version 1.0
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        //����������ģ��Ҫ����
        CountDownLatch countDownLatch = new CountDownLatch(3);

        //������
        new Thread(() -> {
            try {
                System.out.println("�ȴ����ݼ��ء�����");
                System.out.println(String.format("����%d��ǰ������", countDownLatch.getCount()));
                countDownLatch.await();
                System.out.println("���ݼ�����ϡ�����");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(new PreTaskThread(countDownLatch, "���ص�ͼ����")).start();
        new Thread(new PreTaskThread(countDownLatch, "������������")).start();
        new Thread(new PreTaskThread(countDownLatch, "������������")).start();

    }

    /**
     * ����ǰ�������߳�
     */
    static class PreTaskThread implements Runnable {
        private CountDownLatch countDownLatch;
        private String value;

        public PreTaskThread(CountDownLatch countDownLatch, String value) {
            this.countDownLatch = countDownLatch;
            this.value = value;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(value + "complete");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
