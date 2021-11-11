package 深入浅出Java多线程;

/**
 * @ClassName ThreadGroupDemo
 * @Author Chen Langtao
 * @Date 2021/10/2 19:40
 * @Description TODO
 * @Version 1.0
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("group1") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ":" + e.getMessage());
            }
        };


        new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("测试异常");
            }
        }).start();
    }
}
