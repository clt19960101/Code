package List;

import BasicClass.ListNode;

/**
 * @ClassName 合并两个有序链表
 * @Description TODO
 * @Author Langtao
 * @Date 2021/3/21 22:09
 * @Version V1.0
 */

public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(3);
        ListNode listNode1_3 = new ListNode(4);
        listNode1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        ListNode listNode2 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(2);
        ListNode listNode2_3 = new ListNode(3);
        ListNode listNode2_4 = new ListNode(5);
        listNode2.next = listNode2_2;
        listNode2_2.next = listNode2_3;
        listNode2_3.next = listNode2_4;
//        mergeTwoLists(listNode1, listNode2);
        //递归法
        mergeTwoLists_recursion(listNode1, listNode2);
        System.out.println(listNode1);
        System.out.println(listNode2);
    }

    private static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null && listNode2 == null) {
            return null;
        }
        ListNode temp = new ListNode(-1);
        ListNode prev = temp;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                prev.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                prev.next = listNode2;
                listNode2 = listNode2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = listNode1 == null ? listNode2 : listNode1;
        return temp.next;
    }

    private static ListNode mergeTwoLists_recursion(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        if (listNode1.val < listNode2.val) {
            listNode1.next = mergeTwoLists_recursion(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = mergeTwoLists_recursion(listNode1, listNode2.next);
            return listNode2;
        }

    }
}
