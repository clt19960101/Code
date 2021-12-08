package Java核心技术卷一.集合;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @ClassName LinkedListTest
 * @Author Chen Langtao
 * @Date 2021/12/6 23:38
 * @Description 1.合并a和b两个链表;2.从第二个链表中每间隔一个元素删除一个元素;3.removeAll()
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
