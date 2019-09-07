/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 判断一个链表是否为回文链表。
 * 用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题：
 * 1.修改链表结构，将后半部分的链表指针方向反向。
 * 2.两头同时遍历，决定是否符合回文要求。
 *
 * 然鹅我枯惹，，发现自己操纵链表使它反向的过程是辣么笨拙，嘤！
 * 嘤，太辣鸡了我。
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null){
            return true;
        }
        if (head.next!=null&&head.next.next==null){
            if (head.val==head.next.val){
                return true;
            }else{
                return false;
            }
        }

        boolean is=true;
        ListNode cur=head;
        ListNode curDouble=head;
        ListNode tail;
        ListNode tailPre=null;
        ListNode head2;
        //用两个移动速度不同的指针，直到速度快的那个不能移动为止，确定中间结点的位置
        //注意！！！好多次while里面的条件语句本身就出现了空指针，一定一定要注意！
        while (curDouble.next.next!=null){
            cur=cur.next;
            curDouble=curDouble.next.next;
            if (curDouble.next==null||curDouble.next.next==null){
                break;
            }
        }
        //后半链表反向
        //此时的cur后面的链表可以反向了
        tail=cur.next;
        if (curDouble.next!=null){
            curDouble=curDouble.next;
        }
        head2=curDouble;//反向后的链表头部
        //一一修改指针，使链表反向
        while (tail!=null){
            ListNode tempNode=tail.next;
            tail.next=tailPre;
            tailPre=tail;
            tail=tempNode;
        }

        //两半链表进行比较
        cur=head;
        while (cur!=null&&curDouble!=null){
            if (cur.val!=curDouble.val){
                is=false;
                break;
            }else {
                cur=cur.next;
                curDouble=curDouble.next;
            }
        }
        return is;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(0);
        listNode.next.next=new ListNode(0);

        Solution234 solution234=new Solution234();
        solution234.isPalindrome(listNode);
    }
}