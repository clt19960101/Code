package Arrays;

/**
 * @ClassName N����ԲȦ����
 * @Description TODO
 * @Author Langtao
 * @Date 2022/7/12 20:38
 * @Version V1.0
 */

public class N����ԲȦ���� {
    public static void main(String[] args) {
        callNum(21,20);

    }

    public static void callNum(int n,int m){
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        //��Ȧ����
        int count = 0;
        //ÿ���˱�ŵ��±�
        int inx = 1;
        //������
        int num = 0;

        //ֻҪ��Ȧ������û��n-1,����ѭ��
        while (count != (n - 1)) {
            if(arr[inx] != 0){
                num++;
            }

            if (num == m) {
                //��ֵΪ��
                arr[inx] = 0;
                //���±���
                num = 0;
                //��Ȧ��+1
                count++;
            }
            inx++;
            //��ͷ��ʼ
            if (inx > n) {
                inx = 1;
            }
            for (int i : arr) {
                System.out.print(i + "-");
            }
            System.out.println();
        }
    }
}
