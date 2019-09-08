/**
 * 设计链表:
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 总体上这个操作过程需要细心严谨！
 * 需要设计全面的测试用例，尤其是边界的处理。
 */
public class MyLinkedList707 {

    ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList707() {
        head=null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (head==null){
            return -1;
        }else {
            ListNode cur=head;
            if (index<0){
                return -1;
            }else if (index==0){
                return head.val;
            }else {
                for (int i = 1; i <= index; i++) {
                    if (cur.next!=null){
                        cur=cur.next;
                    }else {
                        return -1;
                    }
                }
                return cur.val;
            }
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head==null){
            head=new ListNode(val);
        }else {
            ListNode cur=new ListNode(val);
            cur.next=head;
            head=cur;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode cur=head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=new ListNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index<=0){
            addAtHead(val);
        }else {
            int indexB=0;
            ListNode cur=head;
            while (cur!= null) {
                if (indexB == index - 1) {
                    ListNode tempNode = cur.next;
                    cur.next = new ListNode(val);
                    cur.next.next = tempNode;
                }
                cur = cur.next;
                indexB++;
            }
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode cur=head;
        int indexB=0;
        if (index==0){
            if (cur!=null){
                head=head.next;
            }
        }else{
            while (cur!=null&&index>0){
                if (indexB==index-1){
                    if (cur.next!=null){
                        if (cur.next.next!=null){
                            cur.next=cur.next.next;
                        }else {
                            cur.next=null;
                        }
                    }
                }
                cur=cur.next;
                indexB++;
            }
        }

    }


    public static void main(String[] args) {
        /*
        "MyLinkedList","addAtHead"1,"addAtTail"3,"addAtIndex"1,2,"get"1,"deleteAtIndex"0,"get"0]
         */
        MyLinkedList707 myLinkedList707=new MyLinkedList707();
        myLinkedList707.addAtHead(1);//1
        myLinkedList707.addAtTail(3);//1->3
        myLinkedList707.addAtIndex(1,2);//1->2->3
        myLinkedList707.get(1);
        myLinkedList707.deleteAtIndex(0);//2->3
        myLinkedList707.get(0);

    }

    class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val=x;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */