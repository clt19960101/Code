package ���ܽ���;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * @ClassName ��ǩ��ǩ����ʵ��
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/23 13:05
 * @Version V1.0
 */

public class ��ǩ��ǩ����ʵ�� {
    //SHA-256��ΪժҪ�㷨��RSA��Ϊǩ����ǩ�㷨
    //��Կ�ַ���
    private static final String PUBLIC_KEY_STR = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDaJzVjC5K6kbS2YE2fiDs6H8pB\n" +
            "JFDGEYqqJJC9I3E0Ebr5FsofdImV5eWdBSeADwcR9ppNbpORdZmcX6SipogKx9PX\n" +
            "5aAO4GPesroVeOs91xrLEGt/arteW8iSD+ZaGDUVV3+wcEdci/eCvFlc5PUuZJou\n" +
            "M2XZaDK4Fg2IRTfDXQIDAQAB";
    //˽Կ�ַ���
    private static final String PRIVATE_KEY_STR = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANonNWMLkrqRtLZg\n" +
            "TZ+IOzofykEkUMYRiqokkL0jcTQRuvkWyh90iZXl5Z0FJ4APBxH2mk1uk5F1mZxf\n" +
            "pKKmiArH09floA7gY96yuhV46z3XGssQa39qu15byJIP5loYNRVXf7BwR1yL94K8\n" +
            "WVzk9S5kmi4zZdloMrgWDYhFN8NdAgMBAAECgYA9bz1Bn0i68b2KfqRdgOfs/nbe\n" +
            "0XNN1DLQp2t7WDfRCg01iI1zPkZgyFVZWtI85f5/uIrLs5ArLosL1oNuqqc0nNne\n" +
            "CvJK+ZxvA98Hx3ZqYTzDnleR054YhofL5awbhSciYVic204DOG1rhSsYWMqtX7J7\n" +
            "3geoWL7TYdMfYXcCAQJBAPMMKsz6ZJh98EeQ1tDG5gpAGWFQkYNrxZDelP/LjeO0\n" +
            "TP3XkQnIpcaZoCs7V/rRGRGMWwQ2BUdc/01in89ZZ5ECQQDlx2oBc1CtOAm2UAhN\n" +
            "1xWrPkZWENQ53wTrwXO4qbTGDfBKon0AehLlGCSqxQ71aufLkNO7ZlX0IHTAlnk1\n" +
            "TvENAkAGSEQ69CXxgx/Y2beTwfBkR2/gghKg0QJUUkyLqBlMz3ZGAXJwTE1sqr/n\n" +
            "HiuSAiGhwH0ByNuuEotO1sPGukrhAkAMK26a2w+nzPL+u+hkrwKPykGRZ1zGH+Cz\n" +
            "19AYNKzFXJGgclCqiMydY5T1knBDYUEbj/UW1Mmyn1FvrciHoUG1AkAEMEIuDauz\n" +
            "JabEAU08YmZw6OoDGsukRWaPfjOEiVhH88p00veM1R37nwhoDMGyEGXVeVzNPvk7\n" +
            "cELg28MSRzCK";

    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, IOException, SignatureException, InvalidKeySpecException {
        //ԭʼ����
        String plain = "��ӭ��ҹ�ע�ҵĹ��ںţ������ݵ�С�к�";
        //��ǩ
        byte[] signatureByte = sign(plain);
        System.out.println("ԭʼ������:" + plain);
        System.out.println("��ǩ���:");
        System.out.println(new BASE64Encoder().encode(signatureByte));
        //��ǩ
        boolean verifyResult = verify(plain, signatureByte);
        System.out.println("��ǩ���:" + verifyResult);
    }

    private static byte[] sign(String plain) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, SignatureException, SignatureException {
        //���ݶ�Ӧ�㷨����ȡǩ������ʵ��
        Signature signature = Signature.getInstance("SHA256WithRSA");
        //��ȡ˽Կ����ǩ�õ���˽Կ��˽Կһ�����������ļ�������ģ�����Ϊ����ʾ���㣬����˽Կ�ַ�������˽Կ����
        PrivateKey privateKey = getPriveteKey(PRIVATE_KEY_STR);
        //��ʼ��ǩ������
        signature.initSign(privateKey);
        //��ԭʼ���ĸ��µ�����
        signature.update(plain.getBytes("UTF-8"));
        //��ǩ
        return signature.sign();
    }

    private static PrivateKey getPriveteKey(String privateKeyStr) {
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec priPKCS8;
        try {
            priPKCS8 = new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(privateKeyStr));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            privateKey = keyf.generatePrivate(priPKCS8);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    private static boolean verify(String plain, byte[] signatureByte) throws NoSuchAlgorithmException, InvalidKeyException, IOException, SignatureException, InvalidKeySpecException {
        //��ȡ��Կ
        PublicKey publicKey = getPublicKey(PUBLIC_KEY_STR);
        //���ݶ�Ӧ�㷨����ȡǩ������ʵ��
        Signature signature = Signature.getInstance("SHA256WithRSA");
        //��ʼ��ǩ������
        signature.initVerify(publicKey);
        //��ԭʼ���ĸ��µ�ǩ������
        signature.update(plain.getBytes("UTF-8"));
        //������ǩ
        return signature.verify(signatureByte);
    }

    private static PublicKey getPublicKey(String publicKeyStr) throws InvalidKeySpecException, IOException {
        PublicKey publicKey = null;
        try {
            java.security.spec.X509EncodedKeySpec bobPubKeySpec = new java.security.spec.X509EncodedKeySpec(
                    new BASE64Decoder().decodeBuffer(publicKeyStr));
            // RSA�ԳƼ����㷨
            java.security.KeyFactory keyFactory;
            keyFactory = java.security.KeyFactory.getInstance("RSA");
            // ���ɹ�Կ����
            publicKey = keyFactory.generatePublic(bobPubKeySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return publicKey;
    }


}
