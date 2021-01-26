package Arrays.Stack;

import java.util.Stack;

/**
 * @ClassName GetMinNumStack
 * @Description �õ���ǰջ�е���Сֵ
 * @Author Langtao
 * @Date 2021/1/26 22:57
 * @Version V1.0
 */

public class GetMinNumStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinNumStack() {
        this.dataStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int data) {
        if (this.minStack.isEmpty()) {
            this.minStack.push(data);
        } else if (data < getMinNum()) {
            this.minStack.push(data);
        } else {
            this.minStack.push(this.minStack.peek());
        }
        this.dataStack.push(data);
    }

    public int pop() {
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException("ջ�ѿ�");
        }
        this.minStack.pop();
        return this.dataStack.pop();
    }

    public int getMinNum() {
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException("ջ�ѿ�");
        }
        return this.minStack.peek();
    }
}
