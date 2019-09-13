import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的最大深度
 * !!!还没有accept，我枯惹。
 */

public class Solution559 {
    /*
    孩子兄弟表示法
     */
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static int maxDepth(Node root) {
        Stack<Node> stack=new Stack<>();
        Stack<Integer> s=new Stack<>();
        int maxDepthNum=0;
        if (root!=null){
            stack.push(root);
            s.push(1);
            int childrenSize=0;
            while (!stack.isEmpty()){
                root=stack.pop();
                if (root.children!=null){
                    childrenSize=root.children.size();
                    for (int i = 0; i < childrenSize; i++) {
                        stack.push(root.children.get(i));
                    }
                    s.push(s.peek()+1);
                }else {
                    childrenSize--;
                    if (childrenSize==0){
                        s.push(s.peek()-1);
                    }
                }
            }
        }
        while (!s.isEmpty()){
            int a=s.pop();
            maxDepthNum=a>=maxDepthNum?a:maxDepthNum;
        }
        return maxDepthNum;
    }

    public static void main(String[] args) {
        List<Node> list1=new ArrayList<>();
        list1.add(new Node(5,null));
        list1.add(new Node(6,null));
        List<Node> list2=new ArrayList<>();
        list2.add(new Node(3,list1));
        list2.add(new Node(2,null));
        list2.add(new Node(4,null));
        Node root=new Node(1,list2);

        System.out.println(maxDepth(root));
    }

}
