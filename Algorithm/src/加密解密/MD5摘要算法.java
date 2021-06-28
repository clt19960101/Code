package 加密解密;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5摘要算法
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/22 9:32
 * @Version V1.0
 */

public class MD5摘要算法 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "123";
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes = getMD5Bytes(str.getBytes());
        for (byte temp : bytes) {
            System.out.println(temp);
            if (temp >= 0 && temp < 16) {
                stringBuilder.append("0");
                System.out.println(stringBuilder.toString());
            }
            //0xff的二进制是1111 1111 （8bit）,一个byte也是8bit,一个字节
            //当byte转换成int类型时，高24位会按符号位补齐
            stringBuilder.append(Integer.toHexString(temp & 0xff));
        }
        System.out.println(stringBuilder.toString());
    }

    private static byte[] getMD5Bytes(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        return digest.digest(bytes);


    }
}
