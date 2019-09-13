import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历
 * 迭代
 *
 * 准备工作：
 * 准备两个栈s1和s2；
 * 首先将根节点压入s1；
 * 准备一个List存储遍历结果。
 *
 * 迭代过程：
 * 根节点为s1栈顶出栈的结点；
 * 每次将根节点的孩子链表依次压入s1中，
 * 然后将除了第一个孩子之外的孩子结点从s1中弹出压入s2，这一步是为了让孩子结点出栈顺序与其前序遍历的顺序一样；
 * 将s1栈顶出栈，其结果加入list当中，以此类推。
 */
public class Solution589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<Node> s1=new Stack<>();
            Stack<Node> s2=new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()||!s2.isEmpty()){
                if (!s1.isEmpty()) {
                    root = s1.pop();
                    list.add(root.val);
                } else if (!s2.isEmpty()){
                    root=s2.pop();
                    list.add(root.val);
                }
                //将孩子链表依次存入栈S1
                for (int i = 0; i < root.children.size(); i++) {
                    s1.push(root.children.get(i));
                }
                //只留下孩子结点的第一个在s1
                for (int i = 0; i < root.children.size() - 1; i++) {
                    s2.push(s1.pop());
                }
            }
        }
        return list;
    }


}