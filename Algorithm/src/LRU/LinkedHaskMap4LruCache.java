package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LinkedHaskMap4LruCache
 * @Description �������е� JDK ���ݽṹʵ��һ��Java ��� LRU
 * @Author Langtao
 * @Date 2021/3/13 14:31
 * @Version V1.0
 */

public class LinkedHaskMap4LruCache<K, V> extends LinkedHashMap<K, V> {
    //�������Ļ����С
    private final int CACHE_SIZE;

    public LinkedHaskMap4LruCache(int cacheSize) {
        //true��ʾ�� linkedHashMap ���շ���˳������������������ʵķ���ͷ�������Ϸ��ʵķ���β����
        //Math.floor() ����ȡ������С��������������Ǹ�������
        //Math.ceil() ����ȡ�������������������С���Ǹ�����
        //Math.rint() ������ӽ���ֵ���Ǹ�������ע��: ������������������������򷵻����е�ż����
        //Math.round() �������룬��������Ϊ����ʱ��̫����⣬ֱ����Դ��Ӧ�ñȽϺ���⣬ע�ⷵ�ص������͡�
        //Math.round(x) = Math.floor(x + 0.5)
        super((int) Math.ceil(cacheSize / 0.75 + 1), 0.75f, true);
        this.CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // �� map �е�����������ָ���Ļ��������ʱ�򣬾��Զ�ɾ�����ϵ����ݡ�
        return size() > CACHE_SIZE;
    }
}
