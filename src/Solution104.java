//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

/**
 * 给定一个二叉树，找出其最大深度。
 * 递归。
 */

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int deep;
        int deep1=1;
        int deep2=1;
        if (root.left==null&&root.right==null){
            return 1;
        }
        deep1+=maxDepth(root.left);
        deep2+=maxDepth(root.right);
        deep=deep1>deep2?deep1:deep2;
        return deep;
    }
}
