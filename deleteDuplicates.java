
public class deleteDuplicates {
    /**给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     示例 1:
     输入: 1->2->3->3->4->4->5
     输出: 1->2->5
     示例 2:
     输入: 1->1->1->2->3
     输出: 2->3*/
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x ){val=x;}
    }
    public ListNode solution82(ListNode head) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pre = header;
        ListNode cur = header.next;
        boolean delNode = false;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                pre.next = cur.next;
                cur = cur.next;
                delNode = true;
            } else {
                if (delNode) {
                    pre.next = cur.next;
                    cur = cur.next;
                    delNode = false;
                } else {
                    pre.next = cur;
                    pre = cur;
                    cur = cur.next;
                }
            }
        }
        if (delNode) {
            pre.next = cur.next;
        }
        return header.next;
    }
    public static void main(String[] args){
        deleteDuplicates func = new deleteDuplicates();
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode p=head;
        int[] list = {1,2,3,3,4,4,5};
        for(int i =0;i<list.length;i++){
            ListNode node =new ListNode(list[i]);
            node.next =null;
            p.next = node;
            p=p.next;
        }
        ListNode result = func.solution82(head.next);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
