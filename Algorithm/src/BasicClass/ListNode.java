package BasicClass;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/21 20:55
 * @Version V1.0
 */

public class ListNode {
    public static int val;
    public static ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
