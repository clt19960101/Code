package Arrays.Others;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName 最大数
 * @Description 179
 * @Author Langtao
 * @Date 2021/4/12 22:30
 * @Version V1.0
 */

public class 最大数 {
    public String largestNumber(int[] nums) {
        String [] str_nums = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str_nums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str_nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        if (str_nums[0].charAt(0)=='0'){
            return "0";
        }
        for (String str_num : str_nums) {
            stringBuilder.append(str_num);
        }
        return stringBuilder.toString();

    }
}
