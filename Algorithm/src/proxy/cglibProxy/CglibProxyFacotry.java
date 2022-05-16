package proxy.cglibProxy;


import net.sf.cglib.proxy.Enhancer;

/**
 * CglibProxyFacotry
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/16 11:59 下午
 **/
public class CglibProxyFacotry {

    public static Object getProxy(Class<?> clazz) {
        //创建动态代理类增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new MyInterceptor());
        // 创建代理类
        return enhancer.create();

    }

}
