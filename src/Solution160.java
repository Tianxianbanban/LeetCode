/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 首先是单链表，所以汇聚到一起以后不会分叉！
 * 所以如果两条链表相交的话，只会有一种情况,并且其中：
 * A长；
 * B长；
 * 一样长。
 * 或者是不会相交。
 *
 * 所以要先判断是够非空，
 * 再判断最后一个节点是否共有，如果不是共有，那就没有相交；
 * 如果确定相交，再进行继续的结点查找：
 * 得出链表长度差值，
 * 长的链表指针先行至后续链表长度和短的链表相同，再一同前进，第一次相遇的结点为所求。
 *
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        int lengthA=0;
        int lengthB=0;
        int diffLength;
        boolean isMeet=false;
        if (headA==null||headB==null){
            return null;
        }
        if (curA==curB){
            return curA;
        }
        //将链表分别遍历一次，分别得到长度,但是长度不是重点，差值才是
        while (curA.next!=null){
            lengthA++;
            curA=curA.next;
        }
        while (curB.next!=null){
            lengthB++;
            curB=curB.next;
        }
        //首先确认是否相交
        if (curA==curB){
            isMeet=true;
            curA=headA;
            curB=headB;
        }
        if (isMeet){
            //获得
            diffLength=lengthA-lengthB;
            if (diffLength>=0){//A长
                for (int i = 0; i < diffLength; i++) {
                    curA=curA.next;
                }
            }else {
                for (int i = 0; i < -diffLength; i++) {
                    curB=curB.next;
                }
            }
            //这个时候指针的位置对齐了
            while (curA!=null&&curB!=null){//这个条件的判断要注意下细节！
                if (curA==curB){
                    return curA;
                }
                curA=curA.next;
                curB=curB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA;
        ListNode headB=new ListNode(2);
        headB.next=new ListNode(3);
        headA=headB.next;
        Solution160 solution160=new Solution160();
        solution160.getIntersectionNode(headA,headB);
    }
}
