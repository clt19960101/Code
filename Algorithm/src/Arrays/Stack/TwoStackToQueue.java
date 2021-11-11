package Arrays.Stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName TwoStackToQueue
 * @Description 两个栈实现队列
 * @Author Langtao
 * @Date 2021/1/26 23:26
 * @Version V1.0
 */

public class TwoStackToQueue {
    //入栈
    public Stack<Integer> pushStack;
    //出栈
    public Stack<Integer> popStack;

    public TwoStackToQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    //队列的add方法
    public void add(int data) {
        pushStack.push(data);
        pushStackToPopStack();

    }

    //队列的poll方法
    public int poll() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        //能不能先导数据再弹出
        pushStackToPopStack();
        return pushStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        pushStackToPopStack();
        return popStack.peek();
    }

    //从压入栈向弹出栈导数据
    //1.popStack必须为空时才能导数据
    //2.若要从pushStack中导数据，必须一次性导完
    private void pushStackToPopStack() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

    }
}
