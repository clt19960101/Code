package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName 笨阶乘
 * @Description 1006
 * @Author Langtao
 * @Date 2021/4/1 21:32
 * @Version V1.0
 */

public class 笨阶乘 {

    //使用栈模拟
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;

        //用于控制乘除加减
        int index = 0;
        while (N > 0) {
            if (index % 4 == 0) {//乘法
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {//除法
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {//加法
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
