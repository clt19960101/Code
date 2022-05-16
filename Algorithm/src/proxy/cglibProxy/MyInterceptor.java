package proxy.cglibProxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * MyInterceptor
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/17 12:12 ����
 **/
public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("���ŷ���֮ǰ" + method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        System.out.println("���ŷ���֮��" + method.getName());
        return object;
    }
}
