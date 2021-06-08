package ThreadCode.ProducerConsumerMode;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName Producer_blockingQueue
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/14 22:01
 * @Version V1.0
 */

public class Producer_blockingQueue extends Thread {
    //阻塞队列
    private BlockingQueue<Integer> blockingQueue;

    public Producer_blockingQueue(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int num = new Random().nextInt(100);
                blockingQueue.put(num);
                System.out.println("生产者" + Thread.currentThread().getName() +
                        "生产了产品：" + num + "，此时缓冲区数据量为：" + blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
