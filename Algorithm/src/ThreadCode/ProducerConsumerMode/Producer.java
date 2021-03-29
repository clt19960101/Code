package ThreadCode.ProducerConsumerMode;

import java.util.Queue;

/**
 * @ClassName Producer
 * @Description ������
 * @Author Langtao
 * @Date 2021/3/5 22:46
 * @Version V1.0
 */

public class Producer extends Thread {
    private static final int MAX_QUEUE_SIZE = 5;

    private final Queue sharedQueue;

    public Producer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() >= MAX_QUEUE_SIZE) {
                    System.out.println("�������ˣ��ȴ�����");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sharedQueue.add(i);
                System.out.println("�������� : " + i);
                sharedQueue.notify();
            }
        }
    }
}
