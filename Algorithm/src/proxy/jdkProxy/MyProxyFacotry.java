package proxy.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * CglibProxyFacotry
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/16 11:59 обнГ
 **/
public class MyProxyFacotry {

    public static Object getProxy(Object target) {
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new SmsInvocationHandler(target));
        return proxyInstance;

    }

}
