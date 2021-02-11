package Arrays.Sort.QuickSort;

/**
 * @ClassName QuickSortExample1
 * @Author Chen Langtao
 * @Date 2021/2/11 8:03
 * @Description ����һ����num��һ�����飬�������Ϊ�����������֣�������߲���С��num,�м����num,�ұ߲��ִ���num
 * @Version 1.0
 */
public class NetherLandsFlags {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 4, 2, 3, 5};
        int[] ints = doNetherlandsflags(arr, 0, arr.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }
    }

    /**
     * @Name doNetherlandsflags
     * @Param [arr, left, right]
     * @Retrun ���ص���num�����ұ߽�
     * @Author Chen Langtao
     * @Date 2021/2/11 8:14
     * @Throws
     * @Description һ����arr[R]������ֵ
     */
    private static int[] doNetherlandsflags(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        //С�����ұ߽�
        int less = left - 1;
        //��������߽�
        int more = right;
        //��������
        int index = left;
        while (index < more) {
            //��arr[i]==arr[right]ʱ,less,more�����䣬index++
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                //��arr[i]<numʱ,less����,index++
                swap(arr, index++, ++less);
            } else {
                //��arr[i]>numʱ,more����,index����
                swap(arr, index, --more);
            }
        }
        //left..less  less+1..more-1   more..R-1   R
        //����������һ������right����
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
