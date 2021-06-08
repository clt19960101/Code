package ThreadCode.PrintABC;

/**
 * @ClassName Synchronized_PrintABC
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/13 23:48
 * @Version V1.0
 */

public class Synchronized_PrintABC {
    private static int flag = 1;

    public static void main(String[] args) {
        Object resource = new Object();
        new Thread(() -> {
            synchronized (resource) {
                for (int i = 0; i < 10; i++) {
                    while (flag != 1) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A ");
                    flag = 2;
                    resource.notifyAll();
                }

            }
        }).start();
        new Thread(() -> {
            synchronized (resource) {
                for (int i = 0; i < 10; i++) {
                    while (flag != 2) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = 3;
                    System.out.print("B ");
                    resource.notifyAll();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (resource) {
                for (int i = 0; i < 10; i++) {
                    while (flag != 3) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = 1;
                    System.out.print("C ");
                    resource.notifyAll();
                }
            }
        }).start();

    }
}
