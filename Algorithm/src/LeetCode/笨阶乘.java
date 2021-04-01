package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName ���׳�
 * @Description 1006
 * @Author Langtao
 * @Date 2021/4/1 21:32
 * @Version V1.0
 */

public class ���׳� {

    //ʹ��ջģ��
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;

        //���ڿ��Ƴ˳��Ӽ�
        int index = 0;
        while (N > 0) {
            if (index % 4 == 0) {//�˷�
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {//����
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {//�ӷ�
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
