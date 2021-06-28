package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName HashMapÀ¿—≠ª∑
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/25 23:45
 * @Version V1.0
 */

public class HashMapÀ¿—≠ª∑ {
    public static void main(String[] args) {
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
        new HashMapThread().start();
    }
    public static class HashMapThread extends Thread {
        private static AtomicInteger ai = new AtomicInteger();
        private static Map<Integer, Integer> map = new HashMap<>();

        @Override
        public void run() {
            while (ai.get() < 100000) {
                map.put(ai.get(), ai.get());
                ai.incrementAndGet();
            }
        }
    }

}
