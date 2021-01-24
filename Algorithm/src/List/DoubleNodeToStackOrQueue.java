package List;

import java.util.Stack;

/**
 * @ClassName DoubleNodeToStackOrQueue
 * @Description 双向链表实现栈和队列
 * @Author Langtao
 * @Date 2021/1/24 21:47
 * @Version V1.0
 */

public class DoubleNodeToStackOrQueue {
    public static class DoubleNode<T> {
        public T value;
        DoubleNode<T> last;
        DoubleNode<T> next;

        public DoubleNode(T data) {
            value = data;
        }
    }

    public static class DoubleEndsQueue<T> {
        public DoubleNode<T> head;
        public DoubleNode<T> tail;

        //从头部新增节点
        public void addFromHead(T data) {
            //先构造DoubleNode节点
            DoubleNode<T> cur = new DoubleNode<>(data);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        //从尾部新增节点
        public void addFromTail(T data) {
            //先构造DoubleNode节点
            DoubleNode<T> cur = new DoubleNode<>(data);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        //从头部弹出节点
        public T popFromHead() {
            if (head == null) {
                return null;
            }
            //新建节点记录删除节点
            DoubleNode<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                //新头部节点的last为空
                head.last = null;
            }
            return cur.value;
        }

        //从尾部弹出节点
        public T popFromTail() {
            if (head == null) {
                return null;
            }
            //新建节点记录删除节点
            DoubleNode<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                cur.last = null;
                //新尾部节点的next为空
                tail.next = null;
            }
            return cur.value;
        }
    }

    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T data) {
            queue.addFromHead(data);
        }

        public T pop() {
            return queue.popFromHead();
        }
    }

    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T data) {
            queue.addFromHead(data);
        }

        public T poll() {
            return queue.popFromTail();
        }

    }
}
