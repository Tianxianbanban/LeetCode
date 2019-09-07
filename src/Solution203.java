/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 注意头结点的值可能就是val值相等的情况，
 * 后面正常处理。
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null){
            if (head.val==val){
                head=head.next;
            }else {
                break;
            }
        }
        ListNode cur=head;
        while (cur!=null&&cur.next!=null){
            if (cur.next.val==val&&cur.next.next!=null){
                cur.next=cur.next.next;
            }else if (cur.next.val==val&&cur.next.next==null){
                cur.next=null;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }
}
