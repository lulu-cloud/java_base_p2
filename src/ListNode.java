import java.util.HashMap;
import java.util.Map;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode deleteDuplication(ListNode pHead) {
        /*2022-05-21 23:02*/
        ListNode p=pHead;
        ListNode pre=null;
        while(p!=null){
            //出现重复，删除当前结点
            if(pre!=null&&p.val==pre.val){
                //当前为最后一个结点，将pre.next置null,p=null以便结束循环
                if(p.next==null){
                    pre.next=null;
                    p=null;
                }
                //否则，正常删除该结点
                else {
                    pre.next=p.next;
                    p=p.next;
//                    p.val = p.next.val;
//                    p.next = p.next.next;
                }
            }
            else{
                //temp更新为当前结点的值
                pre=p;
                p=p.next;
            }
        }
        return pHead;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(3);
        head=new ListNode().deleteDuplication(head);
        for(ListNode p=head;p!=null;p=p.next){
            System.out.println(p.val);
        }
    }
}

class Solution_ListNode {
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
