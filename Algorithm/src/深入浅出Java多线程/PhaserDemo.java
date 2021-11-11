package ����ǳ��Java���߳�;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * @ClassName PhaserDemo
 * @Author Chen Langtao
 * @Date 2021/11/7 22:21
 * @Description TODO
 * @Version 1.0
 */
public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(4) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println(String.format("��%d�ιؿ�׼�����", phase + 1));
                return phase == 3 || registeredParties == 0;
            }
        };
        new Thread(new PreTaskThread("���ص�ͼ����",phaser)).start();
        new Thread(new PreTaskThread("������������",phaser)).start();
        new Thread(new PreTaskThread("���ر�������",phaser)).start();
        new Thread(new PreTaskThread("�������ֽ̳�",phaser)).start();

    }

    static class PreTaskThread implements Runnable {
        private String task;
        private Phaser phaser;

        public PreTaskThread(String task, Phaser phaser) {
            this.task = task;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            for (int i = 1; i < 4; i++) {
                try {
                    //�ڶ����𲻼���NPC������
                    if (i >= 2 && "�������ֽ̳�".equals(task)) {
                        continue;
                    }
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(String.format("�ؿ�%d,��Ҫ����%d��ģ�飬��ǰģ�顾%s��", i, phaser.getRegisteredParties(), task));
                    //�ӵڶ����𣬲�����NPC
                    if (i == 1 && "�������ֽ̳�".equals(task)) {
                        System.out.println("�´ιؿ��Ƴ����ء����ֽ̡̳�ģ��");
                        //�Ƴ�һ��ģ��
                        phaser.arriveAndDeregister();
                    } else {
                        phaser.arriveAndAwaitAdvance();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
