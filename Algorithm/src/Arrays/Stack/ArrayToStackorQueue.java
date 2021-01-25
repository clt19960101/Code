package Arrays.Stack;

/**
 * @ClassName ArrayToStackorQueue
 * @Description 数组实现栈和队列
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
                System.out.println("栈已满");
                return;
            }
            arr[index] = data;
            index++;
        }

        public int pop() {
            if (index == 0) {
                System.out.println("栈已空");
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
        //待放元素当前的索引
        private int putIndex;
        //待取元素当前的索引
        private int pollIndex;
        //当前队列的size
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
                throw new RuntimeException("当前队列已满");
            }
            size++;
            arr[putIndex] = value;
            putIndex = nextAvailableIndex(putIndex);

        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("当前队列已空");
            }
            size--;
            int ans = arr[pollIndex];
            pollIndex = nextAvailableIndex(pollIndex);
            return ans;
        }

        //如果现在的下标是i,返回下一个可用索引
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
