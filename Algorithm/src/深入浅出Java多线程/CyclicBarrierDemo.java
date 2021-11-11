package ����ǳ��Java���߳�;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierDemo
 * @Author Chen Langtao
 * @Date 2021/11/7 17:24
 * @Description TODO
 * @Version 1.0
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("���ؿ�����ǰ��������ɣ���ʼ��Ϸ������");
        });

        new Thread(new PreTaskThread("���ص�ͼģ��",cyclicBarrier)).start();
        new Thread(new PreTaskThread("��������ģ��",cyclicBarrier)).start();
        new Thread(new PreTaskThread("���ر�������",cyclicBarrier)).start();

    }

    static class PreTaskThread implements Runnable{
        private String task;
        private CyclicBarrier cyclicBarrier;

        public PreTaskThread(String task, CyclicBarrier cyclicBarrier) {
            this.task = task;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            //�����������ؿ�
            for (int i = 0; i < 4; i++) {
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(String.format("�ؿ�%d������%s���",i,task));
                    cyclicBarrier.await();
                } catch (InterruptedException |BrokenBarrierException e) {
                    e.printStackTrace();
                }
                //��������
                cyclicBarrier.reset();
            }
        }
    }
}
