package LeetCode;

/**
 * @ClassName AddTwoNumbers
 * @Author Chen Langtao
 * @Date 2021/2/13 19:17
 * @Description 给你两个?非空 的链表，表示两个非负的整数。它们每位数字都是按照?逆序?的方式存储的，并且每个节点只能存储?一位?数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0?开头。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class AddTwoNumbers {
    //链表定义
    public static class ListNode {
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

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode tail1 = new ListNode(3);
        ListNode head2 = new ListNode(5);
        ListNode tail2 = new ListNode(7);
        head1.next = tail1;
        head2.next = tail2;

        ListNode listNode = doAddTwoNumbers(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode doAddTwoNumbers(ListNode head1, ListNode head2) {
        ListNode head = null;
        ListNode tail = null;
        //进位
        int carry = 0;
        while (head1 != null || head2 != null) {
            int v1 = head1 == null ? 0 : head1.val;
            int v2 = head2 == null ? 0 : head2.val;
            int sum = v1 + v2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
