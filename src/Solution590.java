import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历;
 * 迭代法。
 */


public class Solution590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    /**
     * 下方的代码思路错误！！！
     * 如果将普通树用孩子兄弟法表示，最后的表现形式是二叉树，
     * 而这可普通树的后续遍历对应的是二叉树的中序遍历。
     */
    /*
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        if (root!=null){
            s1.push(root);
            s2.push(root);
            while (!s2.isEmpty()){
                root=s2.pop();
                if (root.children!=null){
                    for (int i = 0; i < root.children.size(); i++) {
                        s1.push(root.children.get(i));
                        s2.push(root.children.get(i));
                    }
                }
            }
        }
        while (!s1.isEmpty()){
            list.add(s1.pop().val);
        }
        return list;
    }
    */


    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        if (root!=null){
            s2.push(root);
            while (!s2.isEmpty()){
                root=s2.pop();
                s1.push(root);
                if (root.children!=null){
                    for (int i = 0; i < root.children.size(); i++) {
                        s2.push(root.children.get(i));
                    }
                }
            }
            while (!s1.isEmpty()){
                list.add(s1.pop().val);
            }
        }
        return list;
    }
}