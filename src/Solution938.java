import java.util.Stack;

/**
 * 二叉搜索树的范围和:
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 *
 * 二叉搜索树就是二叉排序树。
 */
public class Solution938 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        //对二叉树进行非递归中序遍历，确定L和R之间的范围得出和
        int count=0;

        if (root!=null){
            Stack<TreeNode> stack=new Stack<>();
            while (!stack.isEmpty()||root!=null){
                if (root!=null){
                    stack.push(root);
                    root=root.left;
                }else {
                    root=stack.pop();
                    if (root.val>=L&&root.val<=R){
                        count+=root.val;
                    }
//                    System.out.println(root.val);
                    root=root.right;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(10);
        treeNode1.left=new TreeNode(5);
        treeNode1.right=new TreeNode(15);
        treeNode1.left.left=new TreeNode(3);
        treeNode1.left.right=new TreeNode(7);
        treeNode1.right.right=new TreeNode(18);
        System.out.println(rangeSumBST(treeNode1,7,15));
    }
}
