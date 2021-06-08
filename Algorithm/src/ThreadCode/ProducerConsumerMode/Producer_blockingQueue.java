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
    //��������
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
                System.out.println("������" + Thread.currentThread().getName() +
                        "�����˲�Ʒ��" + num + "����ʱ������������Ϊ��" + blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
