package LRU;

import java.util.*;

/**
 * @ClassName LRUCache
 * @Description LinkedHashMap
 * @Author Langtao
 * @Date 2021/5/15 10:52
 * @Version V1.0
 */

public class LRUCache_LinkedHashMap {
    private int capacity;

    HashMap<Integer,Integer> map;

    public LRUCache_LinkedHashMap(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer,Integer>();
    }

    public int get(int key){
        if (!map.containsKey(key)) {
            return -1;
        }else {
            //��ɾ����λ�ã��ٷ�����λ��
            int remove = map.remove(key);
            map.put(key, remove);
            return remove;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        if (map.size() > capacity) {
            //����capacity,���õ�����ɾ����һ��
            Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
            Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
            Integer key1 = iterator.next().getKey();
            map.remove(key1);
        }
    }
}
