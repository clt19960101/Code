package 深入浅出Java多线程;

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
        //假设有三个模块要加载
        CountDownLatch countDownLatch = new CountDownLatch(3);

        //主任务
        new Thread(() -> {
            try {
                System.out.println("等待数据加载。。。");
                System.out.println(String.format("还有%d个前置任务", countDownLatch.getCount()));
                countDownLatch.await();
                System.out.println("数据加载完毕。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(new PreTaskThread(countDownLatch, "加载地图数据")).start();
        new Thread(new PreTaskThread(countDownLatch, "加载人物数据")).start();
        new Thread(new PreTaskThread(countDownLatch, "加载音乐数据")).start();

    }

    /**
     * 定义前置任务线程
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
