package LeetCode;

/**
 * @ClassName ������ά����
 * @Description 74 ���ַ�
 * ÿ���е����������Ұ��������С�
 * ÿ�еĵ�һ����������ǰһ�е����һ������
 * @Author Langtao
 * @Date 2021/3/30 23:06
 * @Version V1.0
 */

public class ������ά����I {

    /**
     * @return boolean
     * @Author Langtao
     * @Description ���ζ��ֲ���
     * @Date 23:17 2021/3/30
     * @Param matrix target
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);

    }

    private boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;

    }


    /**
     * �Ե�һ�е�Ԫ�ض��ֲ��ң��ҵ����һ��������Ŀ��ֵ��Ԫ�أ�Ȼ���ڸ�Ԫ���������ж��ֲ���Ŀ��ֵ�Ƿ����
     *
     * @param matrix
     * @param target
     * @return
     */
    private int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = low + ((high - low + 1) / 2);
            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;

    }

    //��ν�����ֵmidֵ�����������±�
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = matrix[mid / n][mid % n];
            if (target == x) {
                return true;
            } else if (target > x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
