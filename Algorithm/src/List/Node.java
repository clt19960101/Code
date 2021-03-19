package List;

/**
 * @ClassName Node
 * @Description µ¥Á´±í
 * @Author Langtao
 * @Date 2021/1/22 22:59
 * @Version V1.0
 */

public class Node {
    Node next;
    private int value;

    public Node(int data) {
        this.value = data;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
