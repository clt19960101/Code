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
    //������
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
                    System.out.println("������" + Thread.currentThread().getName() +
                            "�����˲�Ʒ��" + num + "����ʱ������������Ϊ��" + sharedQueue.size());
                    sharedQueue.notifyAll();
                } else {
                    System.out.println("���п��ˣ��ȴ�������");
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
