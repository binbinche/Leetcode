import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

public class rotateRight {
    public ListNode rotateright(ListNode head, int k){
        if(head ==null || head.next ==null)
            return head;
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp =temp.next;
        }
        k = k%length;
        if(k ==0)
            return head;
        ListNode fast= head;
        ListNode slow = head;
        for(int i = 0;i<k;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;
        return result;
    }
}
