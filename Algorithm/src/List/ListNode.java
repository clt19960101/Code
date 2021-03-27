package List;

/**
 * @ClassName ListNode
 * @Author Chen Langtao
 * @Date 2021/3/26 22:14
 * @Description ListNode
 * @Version 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
