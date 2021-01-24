package List;

import java.util.Stack;

/**
 * @ClassName DoubleNodeToStackOrQueue
 * @Description ˫������ʵ��ջ�Ͷ���
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

        //��ͷ�������ڵ�
        public void addFromHead(T data) {
            //�ȹ���DoubleNode�ڵ�
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

        //��β�������ڵ�
        public void addFromTail(T data) {
            //�ȹ���DoubleNode�ڵ�
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

        //��ͷ�������ڵ�
        public T popFromHead() {
            if (head == null) {
                return null;
            }
            //�½��ڵ��¼ɾ���ڵ�
            DoubleNode<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                //��ͷ���ڵ��lastΪ��
                head.last = null;
            }
            return cur.value;
        }

        //��β�������ڵ�
        public T popFromTail() {
            if (head == null) {
                return null;
            }
            //�½��ڵ��¼ɾ���ڵ�
            DoubleNode<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                cur.last = null;
                //��β���ڵ��nextΪ��
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
