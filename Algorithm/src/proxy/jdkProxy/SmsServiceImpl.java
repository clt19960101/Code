package proxy.jdkProxy;

/**
 * SmsServiceImpl
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/16 11:53 ����
 **/
public class SmsServiceImpl implements SmsService {

    @Override
    public void sendSms(String message) {
        System.out.println("���Ͷ��ţ�" + message);
    }
}
