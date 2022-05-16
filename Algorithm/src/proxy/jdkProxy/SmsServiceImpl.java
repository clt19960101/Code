package proxy.jdkProxy;

/**
 * SmsServiceImpl
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/16 11:53 ÏÂÎç
 **/
public class SmsServiceImpl implements SmsService {

    @Override
    public void sendSms(String message) {
        System.out.println("·¢ËÍ¶ÌÐÅ£º" + message);
    }
}
