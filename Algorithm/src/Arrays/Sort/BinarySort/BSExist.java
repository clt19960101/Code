package Arrays.Sort.BinarySort;

/**
 * @ClassName BSExist
 * @Description ��һ������������Ѱ���Ƿ����ĳ����
 * @Author Langtao
 * @Date 2021/1/17 23:53
 * @Version V1.0
 */

public class BSExist {
    public static void main(String[] args) {
        int[] arr = {85, 8, 54, 3, 23};
        doBubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
