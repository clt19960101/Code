package LeetCode;

/**
 * @ClassName AddTwoNumbers
 * @Author Chen Langtao
 * @Date 2021/2/13 19:17
 * @Description ��������?�ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ���?����?�ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�
 * ���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
 * ����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/add-two-numbers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @Version 1.0
 */
public class AddTwoNumbers {
    //������
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
        //��λ
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
