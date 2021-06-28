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
        //1.用增强for循环删除符合条件的多个元素抛出ConcurrentModificationException
//        for (Integer integer : list) {
//            if (integer % 2 == 0) {
//                list.remove(integer);
//            }
//        }

        //2.用普通for循环删除符合条件的多个元素,得到的数据不正确，
        // 如删除第二个元素后，第三个元素变为第二个
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i)%2==0){
//                list.remove(list.get(i));
//            }
//        }

        //使用Iterator进行遍历删除符合条件的多个元素
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 == 0) {
                iterator.remove();
            }
        }
    }





}
