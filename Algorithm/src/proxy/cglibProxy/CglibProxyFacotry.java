package proxy.cglibProxy;


import net.sf.cglib.proxy.Enhancer;

/**
 * CglibProxyFacotry
 *
 * @author Chen Langtao
 * @version 1.0 2022/5/16 11:59 ����
 **/
public class CglibProxyFacotry {

    public static Object getProxy(Class<?> clazz) {
        //������̬��������ǿ��
        Enhancer enhancer = new Enhancer();
        // �����������
        enhancer.setClassLoader(clazz.getClassLoader());
        // ���ñ�������
        enhancer.setSuperclass(clazz);
        // ���÷���������
        enhancer.setCallback(new MyInterceptor());
        // ����������
        return enhancer.create();

    }

}
