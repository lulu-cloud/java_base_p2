import java.util.Map;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(3);
        head=new Solution().sortList(head);
        for(ListNode p=head;p!=null;p=p.next){
            System.out.println(p.val);
        }
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
/*        //排序链表
        2022-3-21 21:20
        选择排序的思想？*/
//        int min=head.val;
        ListNode h=head;
        ListNode i=head;
        for(ListNode p=head;p!=null;p=p.next){
            int min=p.val;
            boolean flag=false;
            for(ListNode q=p.next;q!=null;q=q.next){
                if(min>q.val){
                    min=q.val;
                    i=q;
                    flag=true;
                }
            }
            if(flag) {
                int temp = p.val;
                p.val = i.val;
                i.val = temp;
            }
        }
        return h;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*判定链表是否相交 2022-3-21 21:49*/
        ListNode p=headA,q=headB;
        int la=0,lb=0;
        for( p=headA;p.next!=null;p=p.next) la++;
        for( q=headB;q.next!=null;q=q.next) lb++;
        if(q!=p) return null;
        p=headA;q=headB;
        if(la>lb){
            //a比b长
            for(int i=0;i<Math.abs(la-lb);i++) p=p.next;
        }
        else{
            for(int i=0;i<Math.abs(la-lb);i++) q=q.next;
        }
        for(;p!=null;p=p.next,q=q.next){
            if(p==q)
                return q;
        }
        return null;
    }

}
