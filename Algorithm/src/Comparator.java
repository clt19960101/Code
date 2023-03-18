import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
*
*@ClassName Comparator
*@Description TODO
*@Author Langtao
*@Date 2021/3/7 22:31
*@Version V1.0
*
*/

public class Comparator {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(2);
        integers.add(4);
        integers.add(6);
        Collections.sort(integers, new java.util.Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(integers.toString());

    }
}
