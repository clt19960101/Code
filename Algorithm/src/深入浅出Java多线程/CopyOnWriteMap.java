package 深入浅出Java多线程;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName CopyOnWriteMap
 * @Author Chen Langtao
 * @Date 2021/11/4 0:17
 * @Description TODO
 * @Version 1.0
 */
public class CopyOnWriteMap<K, V> implements Map<K, V>, Cloneable {
    private volatile Map<K, V> internalMap;

    public CopyOnWriteMap() {
        internalMap = new HashMap<K, V>();
    }

    @Override
    public V put(K key, V value) {
        synchronized (this) {

            HashMap<K, V> newMap = new HashMap<>();
            V val = newMap.put(key, value);
            internalMap = newMap;
            return val;
        }
    }

    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        synchronized (this) {
            HashMap<K, V> newMap = new HashMap<>(internalMap);
            newMap.putAll(m);
            internalMap = newMap;
        }

    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }
}
