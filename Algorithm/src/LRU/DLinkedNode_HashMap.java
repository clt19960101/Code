package LRU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName DLinkedNode_HashMap
 * @Description ��ϣ�� + ˫������
 * @Author Langtao
 * @Date 2021/5/15 14:23
 * @Version V1.0
 */

public class DLinkedNode_HashMap {
    static class DLinkedNode {
        private int key;
        private int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //��������
    private int capacity;
    //˫������
    private int size;
    //cache
    Map<Integer, DLinkedNode> cache = new HashMap<>();
    //��ʱhead,tail
    //ʹ��һ��αͷ����dummy head����αβ����dummy tail����ǽ��ޣ�
    //��������ӽڵ��ɾ���ڵ��ʱ��Ͳ���Ҫ������ڵĽڵ��Ƿ����
    DLinkedNode head,tail;

    public DLinkedNode_HashMap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        //��ʼ������ڵ�
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //�½�һ���ڵ�
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            //��ӵ�����ͷ
            addToHead(newNode);
            if (++size > capacity) {
                //�Ƴ�ĩβ�ڵ�
                DLinkedNode oldNode = tail.prev;
                remove(oldNode);
                //�Ƴ�����
                cache.remove(oldNode.key);
                size--;
            }
        } else {
            //���½ڵ�ֵ
            node.value = value;
            remove(node);
            addToHead(node);
        }
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            remove(node);
            addToHead(node);
            return node.value;
        }
    }


    public void addToHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void remove(DLinkedNode oldNode) {
        oldNode.prev.next = oldNode.next;
        oldNode.next.prev = oldNode.prev;
    }


}
