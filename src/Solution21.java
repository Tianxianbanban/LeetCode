import java.util.LinkedList;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 合并两个有序链表
 * 同步遍历两个链表，将有较小值的结点插入队列；
 * 将队列中的结点依次出队组成链表。
 */

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode temp;
        ListNode tempCur;
        Queue<ListNode> queue=new LinkedList<>();
        if (l1==null&&l2==null){
            return null;
        }else if(l1==null&&l2!=null){
            return l2;
        }else if (l1!=null&&l2==null){
            return l1;
        }else {
           while (cur1!=null&&cur2!=null){
               if (cur1.val<=cur2.val){
                   queue.offer(cur1);
                   cur1=cur1.next;
               }else{
                   queue.offer(cur2);
                   cur2=cur2.next;
               }
           }
           if (cur1==null){
               while (cur2!=null){
                   queue.offer(cur2);
                   cur2=cur2.next;
               }
           }
           if (cur2==null){
               while (cur1!=null){
                   queue.offer(cur1);
                   cur1=cur1.next;
               }
           }
           temp=queue.poll();
           tempCur=temp;
           while (!queue.isEmpty()){
               tempCur.next=queue.poll();
               tempCur=tempCur.next;
           }
           return temp;
        }
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);

        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);

        Solution21 solution21=new Solution21();
        solution21.mergeTwoLists(l1,l2);
    }
}
