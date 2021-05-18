package ThreadCode.ProducerConsumerMode;

import java.util.Queue;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/5 22:54
 * @Version V1.0
 */

public class Consumer_waitNotify extends Thread {
    //缓冲区
    private final Queue<Integer> sharedQueue;

    public Consumer_waitNotify(Queue<Integer> sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                if (sharedQueue.size() > 0) {
                    int num = sharedQueue.poll();
                    System.out.println("消费者" + Thread.currentThread().getName() +
                            "消费了产品：" + num + "，此时缓冲区数据量为：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                } else {
                    System.out.println("队列空了，等待生产！");
                }
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
