package 深入浅出Java多线程;

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
                System.out.println(String.format("第%d次关卡准备完成", phase + 1));
                return phase == 3 || registeredParties == 0;
            }
        };
        new Thread(new PreTaskThread("加载地图数据",phaser)).start();
        new Thread(new PreTaskThread("加载人物数据",phaser)).start();
        new Thread(new PreTaskThread("加载背景音乐",phaser)).start();
        new Thread(new PreTaskThread("加载新手教程",phaser)).start();

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
                    //第二关起不加载NPC，跳过
                    if (i >= 2 && "加载新手教程".equals(task)) {
                        continue;
                    }
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(String.format("关卡%d,需要加载%d个模块，当前模块【%s】", i, phaser.getRegisteredParties(), task));
                    //从第二关起，不加载NPC
                    if (i == 1 && "加载新手教程".equals(task)) {
                        System.out.println("下次关卡移除加载【新手教程】模块");
                        //移除一个模块
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
