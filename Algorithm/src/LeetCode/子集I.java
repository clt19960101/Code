package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName �Ӽ�I
 * @Description 78
 * @Author Langtao
 * @Date 2021/3/31 22:45
 * @Version V1.0
 */

public class �Ӽ�I {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * ��ԭ�����е�Ԫ������Ϊn.ԭ�����е�ÿ�����ֿ���������״̬�������Ӽ��кͲ����Ӽ��У�������
     * 1�������Ӽ��У���0�������Ӽ��У���ôÿһ���Ӽ����Զ�Ӧһ������Ϊn��0/1���У���iλ��ʾ
     * ai�Ƿ����Ӽ���.
     * ���Է��� 0/1 ���ж�Ӧ�Ķ����������ô� 0 �� 2^n - 1
     * ���ǿ���ö�� mask��[0,2^n-1],mask �Ķ����Ʊ�ʾ��һ�� 0/1 ���У����ǿ��԰������ 0/1
     * ������ԭ���ϵ���ȡ����������ö�������� 2^n�� mask������Ҳ���ܹ�������е��Ӽ�
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        //Ԫ���ܸ���
        int n = nums.length;
        //(1 << n) == 2^n
        for (int mask = 0; mask < (1 << n); mask++) {
            //ÿ�ε��Ӽ�
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[n - i - 1]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;


    }
}
