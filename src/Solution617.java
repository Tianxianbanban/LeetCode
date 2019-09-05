class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 合并二叉树
 * 递归，对两颗二叉树同时进行先序遍历，
 * 将符合条件的情况合并到t1上面，
 * 注意情况的判断！
 */

public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        /**
         * 要简化思想，不能够饶进递归的迷雾当中！
         */
        if (t1==null&&t2==null){
            return null;
        }else{
            if (t1==null){
                return t2;
            }else if (t2==null){
                return t1;
            }
            t1.val+=t2.val;
            t1.left=mergeTrees(t1.left,t2.left);//子树需要被接收一下
            t1.right=mergeTrees(t1.right,t2.right);
            return t1;
        }
    }
}

