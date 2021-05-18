package ThreadCode.ProducerConsumerMode;

import java.util.concurrent.BlockingQueue;

/**
 * @ClassName Consumer_blockingQueue
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/14 22:04
 * @Version V1.0
 */

public class Consumer_blockingQueue extends Thread {
    private BlockingQueue<Integer> blockingQueue;

    public Consumer_blockingQueue(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer num = blockingQueue.take();
                System.out.println("消费者" + Thread.currentThread().getName() +
                        "消费了产品：" + num + "，此时缓冲区数据量为：" + blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
