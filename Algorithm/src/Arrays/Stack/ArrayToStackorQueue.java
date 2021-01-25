package Arrays.Stack;

/**
 * @ClassName ArrayToStackorQueue
 * @Description ����ʵ��ջ�Ͷ���
 * @Author Langtao
 * @Date 2021/1/24 22:53
 * @Version V1.0
 */

public class ArrayToStackorQueue {
    public static class MyStack {
        private final int limit;
        private int index;
        private int[] arr;

        public MyStack(int limit) {
            this.limit = limit;
            this.arr = new int[limit];
            index = 0;
        }

        public void push(int data) {
            if (index == limit) {
                System.out.println("ջ����");
                return;
            }
            arr[index] = data;
            index++;
        }

        public int pop() {
            if (index == 0) {
                System.out.println("ջ�ѿ�");
                return -1;
            }
            int popIndex = index - 1;
            index--;
            return arr[popIndex];
        }
    }

    public static class MyQueue {
        private int[] arr;
        private final int limit;
        //����Ԫ�ص�ǰ������
        private int putIndex;
        //��ȡԪ�ص�ǰ������
        private int pollIndex;
        //��ǰ���е�size
        private int size;

        public MyQueue(int limit) {
            this.arr = new int[limit];
            putIndex = 0;
            pollIndex = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("��ǰ��������");
            }
            size++;
            arr[putIndex] = value;
            putIndex = nextAvailableIndex(putIndex);

        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("��ǰ�����ѿ�");
            }
            size--;
            int ans = arr[pollIndex];
            pollIndex = nextAvailableIndex(pollIndex);
            return ans;
        }

        //������ڵ��±���i,������һ����������
        private int nextAvailableIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }

    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(2);
        myStack.push(3);
        myStack.push(5);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }


}
