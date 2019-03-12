import java.util.List;

public class swapPairs {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.*/

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    private ListNode solution24(ListNode head){
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = newHead;
        while(p.next!=null && p.next.next !=null){
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            p.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            p = node1;
        }
        return newHead.next;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode p=head;
        for(int i = 1;i<nums.length;i++){
            ListNode temp = new ListNode(nums[i]);
            temp.next = p.next;
            p.next=temp;
            p = p.next;
        }
        swapPairs func = new swapPairs();
        ListNode result = func.solution24(head);
        ListNode q = result;
        while(q!=null){
            System.out.println(q.val);
            q = q.next;
        }
    }
}
