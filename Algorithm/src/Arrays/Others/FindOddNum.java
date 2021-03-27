package Arrays.Others;

/**
 * @ClassName FindOddNum
 * @Description һ����������ֻ��һ���������������Σ�������������ż���Σ�Ѱ�ҳ����������ε���
 * @Author Langtao
 * @Date 2021/1/19 23:08
 * @Version V1.0
 */

public class FindOddNum {
    public static void main(String[] args) {
        //һ��������������
        int[] arr_1 = {1, 3, 4, 3, 4, 6, 6, 6, 6, 7, 7};
        //����������������
        //���������˳���޹�
        int[] arr_2 = {1, 3, 3, 7, 7, 7};
//        System.out.println(FindOddNum_1(arr_1));
        FindOddNum_2(arr_2);
        //��ȡһ��int���͵�ֵ���Ҳ��1��10:1010
        FindOddNum_3(10);
    }

    private static void FindOddNum_3(int i) {
        //   i:1010
        //  ~i:0101
        //~i+1:0110
        // i&((~i)+1):0010
        System.out.println(i & ((~i) + 1));

    }

    private static void FindOddNum_2(int[] arr_2) {
        //0���κ����������κ���
        //����a,b�����������Σ���ô���Ϊa^b
        //�ټ���a,b��NλΪ1
        int eor = 0;
        for (int i = 0; i < arr_2.length; i++) {
            eor ^= arr_2[i];
        }
        //eor=a^b
        //eor!=0;
        //eor��Ȼ��һλ��1�������Ҳ��1
        int rightOne = eor & ((~eor) + 1);
        //eor'
        int onlyOne = 0;
        for (int i = 0; i < arr_2.length; i++) {
            if ((arr_2[i] & rightOne) != 0) {
                onlyOne ^= arr_2[i];
            }

        }
        System.out.println((onlyOne + "," + (eor ^ onlyOne)));
    }

    private static int FindOddNum_1(int[] arr_1) {
        int eor = 0;
        for (int i = 0; i < arr_1.length; i++) {
            eor ^= arr_1[i];
        }
        return eor;
    }


}
