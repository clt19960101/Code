package LeetCode.AC;

/**
 * @ClassName 解码方法
 * @Description 91
 * @Author Langtao
 * @Date 2021/4/21 23:28
 * @Version V1.0
 */

public class 解码方法 {
    public int numDecodings(String s) {

        int n = s.length();
        //设fi表示字符串 s 的前 i 个字符 s[1..i] 的解码方法数
        int[] f = new int[n + 1];
        //空字符串可以有 1 种解码方法，解码出一个空字符串
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            //第一种情况是我们使用了一个字符，即 s[i]进行解码，那么只要 s[i]!=0，它就可以被解码成
            // A?I 中的某个字母。由于剩余的前 i?1 个字符的解码方法数为 fi?1
            if (s.charAt(i-1) != '0') {
                f[i] += f[i - 1];
            }
            //第二种情况是我们使用了两个字符，即 s[i-1] 和 s[i] 进行编码
            //与第一种情况类似，s[i-1]不能等于 0，并且s[i?1] 和 s[i] 组成的整数必须小于等于 26,这样它们就能
            //解码成J~Z中的某个字母
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10
                    + s.charAt(i - 1) - '0') <= 26) {
                f[i] += f[i-2];
            }

        }
        return f[n];
    }
}
