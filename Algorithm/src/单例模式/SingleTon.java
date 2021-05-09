package ����ģʽ;

/**
 * @ClassName SingleTon
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/3 23:29
 * @Version V1.0
 */

public class SingleTon {
    //volatile ��ָֹ��������
    private volatile static SingleTon singleTon;

    //˽�еĹ��췽��
    private SingleTon(){

    }

    //���һ�����е�get����
    public SingleTon getSingleTon() {
        //���ж϶����Ƿ�ʵ��������û��������������
        if (singleTon == null) {
            synchronized (SingleTon.class){
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }


}
