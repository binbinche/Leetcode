public class mergeKList {
    /**合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
    示例:
    输入:
    [
    1->4->5,
    1->3->4,
    2->6
    ]
    输出: 1->1->2->3->4->4->5->6*/
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode solutions23(ListNode[] lists){
        if(lists==null||lists.length==0)
            return null;
        return Msort(lists, 0, lists.length-1);
    }
    private ListNode Msort(ListNode[] lists, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            ListNode leftList = Msort(lists, low, mid);
            ListNode rightList = Msort(lists, mid+1, high);
            return mergeList(leftList, rightList);
        }
        return lists[low];
    }
    private ListNode mergeList(ListNode list1, ListNode list2){
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            }else{
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        if(list1!=null)
            p.next = list1;
        if(list2!=null)
            p.next = list2;
        return head.next;
    }
}
