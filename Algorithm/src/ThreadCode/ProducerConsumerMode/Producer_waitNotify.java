package ThreadCode.ProducerConsumerMode;

import java.util.Queue;
import java.util.Random;

/**
 * @ClassName Producer
 * @Description 生产者
 * @Author Langtao
 * @Date 2021/3/5 22:46
 * @Version V1.0
 */

public class Producer_waitNotify extends Thread {
    //缓冲区大小
    private static final int MAX_QUEUE_SIZE = 5;
    //缓冲区
    private final Queue<Integer> sharedQueue;

    public Producer_waitNotify(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                if (sharedQueue.size() < MAX_QUEUE_SIZE) {
                    int anInt = new Random().nextInt(100);
                    sharedQueue.offer(anInt);
                    System.out.println("进行生产,当前库存:" + sharedQueue.size());
                    sharedQueue.notifyAll();

                } else {
                    System.out.println("队列满了，等待消费");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
