/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 删除排序链表中的重复元素
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode=head;
        ListNode cur=head;
        while (cur!=null&&cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(1);
        listNode.next.next=new ListNode(2);

        Solution83 solution83=new Solution83();
        solution83.deleteDuplicates(listNode);
    }
}