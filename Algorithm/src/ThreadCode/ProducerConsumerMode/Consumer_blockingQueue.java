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
                System.out.println("������" + Thread.currentThread().getName() +
                        "�����˲�Ʒ��" + num + "����ʱ������������Ϊ��" + blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
