package ThreadCode.PrintABC;

/**
 * @ClassName Volatile_PrintABC
 * @Description ������ʽ�����ӡABC
 * @Author Langtao
 * @Date 2021/3/19 0:06
 * @Version V1.0
 */

public class Volatile_PrintABC extends Thread {
    private volatile static int state = 0;
    private static String str = "ABC";
    private int index;

    public Volatile_PrintABC(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ) {
            if (state % 3 == index) {
                System.out.print(str.charAt(index)+" ");
                state++;
                //i++�õ������Ժ��ܱ�֤˳���ӡ
                i++;
            }
        }
    }

    public static void main(String[] args) {
        new Volatile_PrintABC(0).start();
        new Volatile_PrintABC(1).start();
        new Volatile_PrintABC(2).start();
    }
}
