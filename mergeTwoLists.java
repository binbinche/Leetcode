public class mergeTwoLists {
    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode solution21(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode p = list;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }
        while (l1 != null) {
            list.next = l1;
            l1 = l1.next;
            list = list.next;
        }
        while (l2 != null) {
            list.next = l2;
            l2 = l2.next;
            list = list.next;
        }
        return p.next;
    }
}
