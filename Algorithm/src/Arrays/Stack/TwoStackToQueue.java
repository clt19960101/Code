package Arrays.Stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName TwoStackToQueue
 * @Description ����ջʵ�ֶ���
 * @Author Langtao
 * @Date 2021/1/26 23:26
 * @Version V1.0
 */

public class TwoStackToQueue {
    //��ջ
    public Stack<Integer> pushStack;
    //��ջ
    public Stack<Integer> popStack;

    public TwoStackToQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    //���е�add����
    public void add(int data) {
        pushStack.push(data);
        pushStackToPopStack();

    }

    //���е�poll����
    public int poll() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        //�ܲ����ȵ������ٵ���
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

    //��ѹ��ջ�򵯳�ջ������
    //1.popStack����Ϊ��ʱ���ܵ�����
    //2.��Ҫ��pushStack�е����ݣ�����һ���Ե���
    private void pushStackToPopStack() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

    }
}
