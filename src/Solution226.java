//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
//
///**
// * 翻转二叉树
// * 递归，每次交换左右子树的引用。
// */
//
//public class Solution226 {
//    public TreeNode invertTree(TreeNode root) {
//        if (root!=null){
//            if (root.left!=null&&root.right!=null){
//                TreeNode temp=root.left;
//                root.left=root.right;
//                root.right=temp;
//            }else if (root.left==null&&root.right!=null){
//                root.left=root.right;
//                root.right=null;
//            }else if (root.right==null&&root.left!=null){
//                root.right=root.left;
//                root.left=null;
//            }
//            invertTree(root.left);
//            invertTree(root.right);
//        }
//        return root;
//    }
//}
