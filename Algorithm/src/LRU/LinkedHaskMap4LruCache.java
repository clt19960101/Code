package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LinkedHaskMap4LruCache
 * @Description 利用已有的 JDK 数据结构实现一个Java 版的 LRU
 * @Author Langtao
 * @Date 2021/3/13 14:31
 * @Version V1.0
 */

public class LinkedHaskMap4LruCache<K, V> extends LinkedHashMap<K, V> {
    //传进来的缓存大小
    private final int CACHE_SIZE;

    public LinkedHaskMap4LruCache(int cacheSize) {
        //true表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        //Math.floor() 向下取整，即小于这个数的最大的那个整数。
        //Math.ceil() 向上取整，即大于这个数的最小的那个整数
        //Math.rint() 返回最接近该值的那个整数。注意: 如果存在两个这样的整数，则返回其中的偶数。
        //Math.round() 四舍五入，但当参数为负数时不太好理解，直接上源码应该比较好理解，注意返回的是整型。
        //Math.round(x) = Math.floor(x + 0.5)
        super((int) Math.ceil(cacheSize / 0.75 + 1), 0.75f, true);
        this.CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当 map 中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > CACHE_SIZE;
    }
}
