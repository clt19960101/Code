package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName 遍历方式
 * @Description TODO
 * @Author Langtao
 * @Date 2021/4/3 19:17
 * @Version V1.0
 */

public class 遍历方式 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "java");
        map.put(2, "JRE");
        map.put(3, "JDK");
        map.put(4, "PHP");
        //entryset遍历
        //迭代器
        System.out.println("entrySet 迭代器===================");
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
        //keyset遍历
        System.out.println("keyset遍历 迭代器===================");
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator1 = integers.iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            System.out.println(next + ":" + map. get(next));
        }
        //foreach
        System.out.println("keyset遍历 for Each===================");
        for (Integer integer : integers) {
            System.out.println(integer + ":" + map.get(integer));
        }
        //Lambda 遍历
        System.out.println("Lambda 遍历===================");
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        System.out.println("Streams API单线程===================");
        //Streams API单线程
        map.entrySet().stream().forEach((entry)->{
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });
        //Streams API多线程
        System.out.println("Streams API多线程===================");
        map.entrySet().parallelStream().forEach((entry)->{
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });


    }
}
