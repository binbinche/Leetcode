public class reverseKGroup {
    /**给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
     k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
     示例 :
     给定这个链表：1->2->3->4->5
     当 k = 2 时，应当返回: 2->1->4->3->5
     当 k = 3 时，应当返回: 3->2->1->4->5
     说明 :
     你的算法只能使用常数的额外空间。
     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。*/
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x ){
            val = x;
        }
    }
    private ListNode solution25(ListNode head, int k ){
        if(head== null)
            return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = newHead;
        ListNode pre = newHead;
        int count =0;
        while(p !=null){
            if(count !=k){
                p=p.next;
                count++;
            }else{
                ListNode pNext = p.next;
                p.next = null;
                ListNode sNode = pre.next;
                ListNode preSNode = sNode;
                pre.next = pNext;
                while(sNode!=null){
                    ListNode node = sNode;
                    sNode = sNode.next;
                    node.next = pre.next;
                    pre.next = node;
                }
                pre = preSNode;
                count = 0;
                p=pre;
            }
        }
        return newHead.next;
    }
    public static void main(String[] args){
        int[] nums ={1,2,3,4,5};
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode p = head;
        for(int i = 1;i<nums.length;i++){
            ListNode node = new ListNode(nums[i]);
            node.next = p.next;
            p.next = node;
            p  = p.next;
        }
        reverseKGroup func = new reverseKGroup();
        ListNode result = func.solution25(head, 3);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }

}
