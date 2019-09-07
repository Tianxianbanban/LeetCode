/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * 环形链表
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode cur=head;
        ListNode curDouble=head;
        boolean isCircle=false;
        //我枯了，条件
        while (cur!=null&&curDouble!=null&&curDouble.next!=null){
            cur=cur.next;
            curDouble=curDouble.next.next;
            if (cur==curDouble){
                isCircle=true;
                break;
            }
        }
        return isCircle;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        Solution141 solution141=new Solution141();
        System.out.println(solution141.hasCycle(listNode));
    }
}
