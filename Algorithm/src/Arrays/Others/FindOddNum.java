package Arrays.Others;

/**
 * @ClassName FindOddNum
 * @Description 一个数组中有只有一个数出现了奇数次，其他数出现了偶数次，寻找出现了奇数次的数
 * @Author Langtao
 * @Date 2021/1/19 23:08
 * @Version V1.0
 */

public class FindOddNum {
    public static void main(String[] args) {
        //一个数出现奇数次
        int[] arr_1 = {1, 3, 4, 3, 4, 6, 6, 6, 6, 7, 7};
        //两个数出现奇数次
        //异或运算与顺序无关
        int[] arr_2 = {1, 3, 3, 7, 7, 7};
//        System.out.println(FindOddNum_1(arr_1));
        FindOddNum_2(arr_2);
        //提取一个int类型的值最右侧的1来10:1010
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
        //0和任何数异或等于任何数
        //假设a,b出现了奇数次，那么结果为a^b
        //再假设a,b第N位为1
        int eor = 0;
        for (int i = 0; i < arr_2.length; i++) {
            eor ^= arr_2[i];
        }
        //eor=a^b
        //eor!=0;
        //eor必然有一位是1，找最右侧的1
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
