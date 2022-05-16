package proxy;

import proxy.cglibProxy.CglibProxyFacotry;
import proxy.cglibProxy.SendMessage;
import proxy.jdkProxy.MyProxyFacotry;
import proxy.jdkProxy.SmsService;
import proxy.jdkProxy.SmsServiceImpl;

/**
 * DynimicProxyTest
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/17 12:02 ����
 **/
public class DynimicProxyTest {

    public static void main(String[] args) {
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsService service = (SmsService) MyProxyFacotry.getProxy(smsService);
        service.sendSms("JDK��̬����");

        SendMessage proxy = (SendMessage)CglibProxyFacotry.getProxy(SendMessage.class);
        proxy.sendMsg("cglib��̬����");
    }

}
