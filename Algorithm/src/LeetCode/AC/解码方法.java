package LeetCode.AC;

/**
 * @ClassName ���뷽��
 * @Description 91
 * @Author Langtao
 * @Date 2021/4/21 23:28
 * @Version V1.0
 */

public class ���뷽�� {
    public int numDecodings(String s) {

        int n = s.length();
        //��fi��ʾ�ַ��� s ��ǰ i ���ַ� s[1..i] �Ľ��뷽����
        int[] f = new int[n + 1];
        //���ַ��������� 1 �ֽ��뷽���������һ�����ַ���
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            //��һ�����������ʹ����һ���ַ����� s[i]���н��룬��ôֻҪ s[i]!=0�����Ϳ��Ա������
            // A?I �е�ĳ����ĸ������ʣ���ǰ i?1 ���ַ��Ľ��뷽����Ϊ fi?1
            if (s.charAt(i-1) != '0') {
                f[i] += f[i - 1];
            }
            //�ڶ������������ʹ���������ַ����� s[i-1] �� s[i] ���б���
            //���һ��������ƣ�s[i-1]���ܵ��� 0������s[i?1] �� s[i] ��ɵ���������С�ڵ��� 26,�������Ǿ���
            //�����J~Z�е�ĳ����ĸ
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10
                    + s.charAt(i - 1) - '0') <= 26) {
                f[i] += f[i-2];
            }

        }
        return f[n];
    }
}
