package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ����Ͱ����
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/21 10:45
 * @Version V1.0
 */

public class ����Ͱ������� {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] arr = new int[]{1, 4, 2, 3, 3};
        System.out.println(maxArea(arr));
    }

    private static int maxArea(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int thisMaxArea = 0;
            for (int j = i+1; j < arr.length; j++) {
                thisMaxArea = Math.max(thisMaxArea, Math.min(arr[i], arr[j]) * (j - i));
            }
            ans += thisMaxArea;
        }
        return ans;
    }
}
