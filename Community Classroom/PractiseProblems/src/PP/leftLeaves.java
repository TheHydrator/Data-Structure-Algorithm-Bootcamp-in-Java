package PP;


import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int sumLeftLeaves = 0;
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//
//            if (node.left != null) {
//                if (node.left.left == null && node.left.right == null) {
//                    sumLeftLeaves += node.left.val;
//                } else {
//                    queue.offer(node.left);
//                }
//            }
//
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//
//        return sumLeftLeaves;
//    }

    // sum of left leaves using recursion.
    public int SumOfLeftLeaves(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum_of_leftLeaves = 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                sum_of_leftLeaves = sum_of_leftLeaves + root.left.val;
            }else{
                sum_of_leftLeaves += SumOfLeftLeaves(root.left);
            }
        }
        if(root.right != null){
            if(root.right.left != null || root.right.right != null){
                sum_of_leftLeaves += SumOfLeftLeaves(root.right);
            }
        }
        return sum_of_leftLeaves;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTree binaryTree = new BinaryTree();
        System.out.println(binaryTree.SumOfLeftLeaves(root)); // Output: 24 (9 + 15)
    }
}

