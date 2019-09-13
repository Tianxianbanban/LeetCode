import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */

public class Solution107 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        Stack<List<Integer>> stack=new Stack<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root!=null){
            ((LinkedList<TreeNode>) queue).add(root);
            int childrenSize=1;
            int chilerenSizeNext=0;
            while (!queue.isEmpty()){
                List<Integer> valueList=new ArrayList<>();
                for (int i = 0; i < childrenSize; i++) {
                    root = queue.poll();
                    valueList.add(root.val);
                    if (root.left!=null){
                        ((LinkedList<TreeNode>) queue).add(root.left);
                        chilerenSizeNext+=1;
                    }
                    if (root.right!=null){
                        ((LinkedList<TreeNode>) queue).add(root.right);
                        chilerenSizeNext+=1;
                    }
                }
                stack.push(valueList);
                childrenSize=chilerenSizeNext;
                chilerenSizeNext=0;
            }
        }
        while (!stack.isEmpty()){
            lists.add(stack.pop());
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(3);
        node.right.left=new TreeNode(4);
        node.right.right=new TreeNode(5);

        List<List<Integer>> lists=levelOrderBottom(node);
        for (int i = 0; i < lists.size(); i++) {
            for (int i1 = 0; i1 < lists.get(i).size(); i1++) {
                System.out.println(lists.get(i).get(i1));
            }
            System.out.println();
        }

    }
}
