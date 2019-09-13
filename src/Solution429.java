import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历:
 * 使用队列，在每个结点出队的同时，使这个结点的孩子list入队，
 * 同时由于方法返回类型的特点，需要为每一层的结点数量计数。
 */

public class Solution429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        if (root!=null){
            queue.add(root);
            int childrenSize=1;//准备好根节点的出队
            while (!queue.isEmpty()){
                List<Integer> childLevelList=new ArrayList<>();
                int childrenSizeNext=0;//用于记录下一层的结点数量
                for (int i = 0; i < childrenSize; i++) {
                    //结点出队，将其值加入到list当中，同时这个结点的孩子结点入队，
                    // 记录下一层结点数量的计数器更新数值
                    root=queue.poll();
                    childLevelList.add(root.val);
                    if (root.children!=null){
                        childrenSizeNext+=root.children.size();
                        queue.addAll(root.children);
                    }
                }
                lists.add(childLevelList);
                childrenSize=childrenSizeNext;
            }
        }
        return lists;
    }
}
