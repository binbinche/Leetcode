public class sorList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode sortList(ListNode head){
        if(head==null || head.next ==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        ListNode l = merge(l1,l2);
        return l;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1==null)
            return l2;
        if(l2 ==null)
            return l1;
        ListNode head, temp;
        if(l1.val <l2.val){
            head = l1;
            l1 = l1.next;
        }
        else{
            head = l2;
            l2 = l2.next;
        }
        temp = head;
        while(l1!=null && l2 !=null){
            if(l1.val<l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            temp.next = l2;
        }
        if(l2 == null)
            temp.next = l1;
        return head;
    }
    public static void main(String[] args){
        int[] nums = {4,2,1,3};
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode temp = head;
        for(int i =0;i<nums.length;i++){
            ListNode p = new ListNode(nums[i]);
            p.next = null;
            temp.next = p;
            temp = temp.next;
        }
        sorList func = new sorList();
        ListNode result = func.sortList(head.next);
        temp = result;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
