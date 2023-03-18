package Arrays;

/**
 * @ClassName N个人圆圈报数
 * @Description TODO
 * @Author Langtao
 * @Date 2022/7/12 20:38
 * @Version V1.0
 */

public class N个人圆圈报数 {
    public static void main(String[] args) {
        callNum(21,20);

    }

    public static void callNum(int n,int m){
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        //退圈的人
        int count = 0;
        //每个人编号的下标
        int inx = 1;
        //报的数
        int num = 0;

        //只要退圈的人数没到n-1,继续循环
        while (count != (n - 1)) {
            if(arr[inx] != 0){
                num++;
            }

            if (num == m) {
                //赋值为零
                arr[inx] = 0;
                //重新报数
                num = 0;
                //出圈人+1
                count++;
            }
            inx++;
            //从头开始
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
