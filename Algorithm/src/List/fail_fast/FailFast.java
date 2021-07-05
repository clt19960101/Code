package List.fail_fast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName FailFast
 * @Description TODO
 * @Author Langtao
 * @Date 2021/5/31 21:15
 * @Version V1.0
 */

public class FailFast {

    private static ArrayList<Integer> list;

    public static void main(String[] args) {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //1.����ǿforѭ��ɾ�����������Ķ��Ԫ���׳�ConcurrentModificationException
//        for (Integer integer : list) {
//            if (integer % 2 == 0) {
//                list.remove(integer);
//            }
//        }

        //2.����ͨforѭ��ɾ�����������Ķ��Ԫ��,�õ������ݲ���ȷ��
        // ��ɾ���ڶ���Ԫ�غ󣬵�����Ԫ�ر�Ϊ�ڶ���
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i)%2==0){
//                list.remove(list.get(i));
//            }
//        }

        //ʹ��Iterator���б���ɾ�����������Ķ��Ԫ��
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 == 0) {
                iterator.remove();
            }
        }
    }





}
