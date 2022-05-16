package proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import javax.annotation.Resource;

/**
 * SmsInvocationHandler
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/16 11:54 下午
 **/
public class SmsInvocationHandler implements InvocationHandler {

    private final Object target;

    public SmsInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("发送短信前处理" + method.getName());
        Object o = method.invoke(target, args);
        System.out.println("发送短信后处理" + method.getName());
        return o;
    }
}
