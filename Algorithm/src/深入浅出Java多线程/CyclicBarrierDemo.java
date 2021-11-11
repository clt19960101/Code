package 深入浅出Java多线程;

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
            System.out.println("本关卡所有前置任务完成，开始游戏。。。");
        });

        new Thread(new PreTaskThread("加载地图模型",cyclicBarrier)).start();
        new Thread(new PreTaskThread("加载人物模型",cyclicBarrier)).start();
        new Thread(new PreTaskThread("加载背景音乐",cyclicBarrier)).start();

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
            //假设有三个关卡
            for (int i = 0; i < 4; i++) {
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(String.format("关卡%d的任务%s完成",i,task));
                    cyclicBarrier.await();
                } catch (InterruptedException |BrokenBarrierException e) {
                    e.printStackTrace();
                }
                //重置屏障
                cyclicBarrier.reset();
            }
        }
    }
}
