package LRU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName DLinkedNode_HashMap
 * @Description 哈希表 + 双向链表
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

    //缓存容量
    private int capacity;
    //双链表长度
    private int size;
    //cache
    Map<Integer, DLinkedNode> cache = new HashMap<>();
    //临时head,tail
    //使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，
    //这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在
    DLinkedNode head,tail;

    public DLinkedNode_HashMap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        //初始化链表节点
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //新建一个节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            //添加到链表头
            addToHead(newNode);
            if (++size > capacity) {
                //移除末尾节点
                DLinkedNode oldNode = tail.prev;
                remove(oldNode);
                //移除缓存
                cache.remove(oldNode.key);
                size--;
            }
        } else {
            //更新节点值
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
