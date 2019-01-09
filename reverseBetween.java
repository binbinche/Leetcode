public class reverseBetween {
    /**反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     说明:
     1 ≤ m ≤ n ≤ 链表长度。
     示例:
     输入: 1->2->3->4->5->NULL, m = 2, n = 4
     输出: 1->4->3->2->5->NULL*/
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public ListNode solution92(ListNode head, int m, int n){
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pre = header;
        ListNode cur = head;
        ListNode temp = new ListNode(-1);
        temp.next = null;
        int k = 1;
        while(k<m){
            pre = pre.next;
            cur = cur.next;
            k++;
        }
        while(k>=m&&k<=n){
            ListNode p = cur;
            cur = cur.next;
            p.next = temp.next;
            temp.next = p;
            k++;
        }
        ListNode reverseList = temp.next;
        while(reverseList!=null){
            pre.next = reverseList;
            pre = pre.next;
            reverseList = reverseList.next;
        }
        pre.next = cur;
        return header.next;
    }
    public static void main(String [] args){
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode p = head;
        int [] value = {1,2,3,4,5};
        int len = value.length;
        for(int i=0;i<len;i++){
            ListNode q = new ListNode(value[i]);
            q.next=null;
            p.next = q;
            p = p.next;
        }
        reverseBetween func = new reverseBetween();
        int m = 2,n=4;
        ListNode result = func.solution92(head.next,m,n);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
