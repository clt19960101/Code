package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ������ʽ
 * @Description TODO
 * @Author Langtao
 * @Date 2021/4/3 19:17
 * @Version V1.0
 */

public class ������ʽ {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "java");
        map.put(2, "JRE");
        map.put(3, "JDK");
        map.put(4, "PHP");
        //entryset����
        //������
        System.out.println("entrySet ������===================");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
        }
        //for each
        System.out.println("entrySet for Each===================");
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //keyset����
        System.out.println("keyset���� ������===================");
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator1 = integers.iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            System.out.println(next + ":" + map. get(next));
        }
        //foreach
        System.out.println("keyset���� for Each===================");
        for (Integer integer : integers) {
            System.out.println(integer + ":" + map.get(integer));
        }
        //Lambda ����
        System.out.println("Lambda ����===================");
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        System.out.println("Streams API���߳�===================");
        //Streams API���߳�
        map.entrySet().stream().forEach((entry)->{
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });
        //Streams API���߳�
        System.out.println("Streams API���߳�===================");
        map.entrySet().parallelStream().forEach((entry)->{
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });


    }
}
