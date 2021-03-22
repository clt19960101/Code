package ThreadCode.ProducerConsumerMode;

import java.util.Queue;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/5 22:54
 * @Version V1.0
 */

public class Consumer extends Thread {
    private final Queue sharedQueue;

    public Consumer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == 0) {
                    System.out.println("队列空了，等待生产！");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int poll = (int) sharedQueue.poll();
                System.out.println("进行消费：" + poll);
                sharedQueue.notify();
            }
        }
    }
}
