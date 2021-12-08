package Java���ļ�����һ.����;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @ClassName LinkedListTest
 * @Author Chen Langtao
 * @Date 2021/12/6 23:38
 * @Description 1.�ϲ�a��b��������;2.�ӵڶ���������ÿ���һ��Ԫ��ɾ��һ��Ԫ��;3.removeAll()
 * @Version 1.0
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        LinkedList<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> aiter = a.listIterator();
        for (String s : b) {
            if (aiter.hasNext()) {
                aiter.next();
            }
            aiter.add(s);
        }
        System.out.println(a);


        Iterator<String> iterator = b.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        System.out.println(b);

        a.removeAll(b);
        System.out.println(a);


    }
}
