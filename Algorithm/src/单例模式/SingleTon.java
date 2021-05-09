package 单例模式;

/**
 * @ClassName SingleTon
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/3 23:29
 * @Version V1.0
 */

public class SingleTon {
    //volatile 防止指令重排序
    private volatile static SingleTon singleTon;

    //私有的构造方法
    private SingleTon(){

    }

    //外放一个共有的get方法
    public SingleTon getSingleTon() {
        //先判断对象是否被实例化过，没有则进入加锁代码
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
