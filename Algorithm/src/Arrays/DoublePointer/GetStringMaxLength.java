package Arrays.DoublePointer;

/**
 * 一个含有多个空格的ASCII串，求最长非空格字符串的长度，尽可能最优。例如，输入："aa bc aaaa aaa"，输出：4；
 */
public class GetStringMaxLength {
    public static void main(String[] args) {
        String str = "  ";
        char[] chars = str.toCharArray();
        int MaxCount = getMaxCount(chars);
        System.out.println(MaxCount);
    }

    private static int getMaxCount(char[] chars) {
        int Count = 0;
        int MaxCount=0;
        //慢指针
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] ==' ') {
                j=i;
                continue;
            }
            if (chars[i] != chars[j]) {
                j=i;
                i--;
                Count = 0;
            } else {
                Count++;
            }
            MaxCount = Math.max(Count,MaxCount);
        }
        return MaxCount;
    }
}
