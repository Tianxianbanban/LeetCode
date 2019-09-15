import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，
 * 并且每个结点没有左子结点，只有一个右子结点。
 */
public class Solution897 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        Queue<TreeNode> queue=new LinkedList<>();
        //对这棵二叉树进行非递归中序遍历
        if (root!=null){
            while (!stack.isEmpty()||root!=null){
                if (root!=null){
                    stack.push(root);
                    root=root.left;
                }else {
                    root=stack.pop();
                    ((LinkedList<TreeNode>) queue).add(root);
                    root=root.right;
                }
            }
        }
        TreeNode head=queue.poll();
        TreeNode current=head;
        current.left=null;
        while (!queue.isEmpty()){
            current.right=queue.poll();
            current=current.right;
            current.left=null;
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(8);
        root.left.left.left=new TreeNode(1);
        root.right.right.left=new TreeNode(7);
        root.right.right.right=new TreeNode(9);

        TreeNode treeNode=increasingBST(root);
        System.out.println();


        TreeNode head1=new TreeNode(378);
        head1.left=new TreeNode(778);
        TreeNode treeNode1=increasingBST(head1);
        System.out.println();
    }

}

