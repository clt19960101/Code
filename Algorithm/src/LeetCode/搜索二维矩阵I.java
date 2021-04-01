package LeetCode;

/**
 * @ClassName 搜索二维矩阵
 * @Description 74 二分法
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数
 * @Author Langtao
 * @Date 2021/3/30 23:06
 * @Version V1.0
 */

public class 搜索二维矩阵I {

    /**
     * @return boolean
     * @Author Langtao
     * @Description 两次二分查找
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
     * 对第一列的元素二分查找，找到最后一个不大于目标值的元素，然后在该元素所在行中二分查找目标值是否存在
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

    //如何将计算值mid值关联到数组下标
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
