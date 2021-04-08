package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ɭ���е�����
 * @Description 781
 * @Author Langtao
 * @Date 2021/4/4 13:14
 * @Version V1.0
 */

public class ɭ���е����� {
    public int numRabbits(int[] answers) {
        /**
         * һ��أ������xֻ���ӻش�y,��ô������x/(y+1)����ȡ������ɫ
         * ��ÿ����ɫ������x/(y+1)����ȡ��*(y+1)������
         * ÿ����ɫ�������ۼӱ�õ����
         */
        //ͳ�ƻش���ͬ�����Ӹ���
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int y : answers) {
            counts.put(y, counts.getOrDefault(y, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            //�ش�y������x
            Integer x = entry.getValue();
            //�ش�y
            Integer y = entry.getKey();
            //Math.ceil(x/(y+1))==(x+y)/(y+1)
            res += (x + y) / (y + 1) * (y + 1);
        }
        return res;
    }

}
