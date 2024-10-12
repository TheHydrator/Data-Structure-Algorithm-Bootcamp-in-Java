package BT;

public class PathSum {
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        TreeNode() {
        } // default constructor

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null){
                return false;
            }
            if(root.value == targetSum && root.left == null && root.right == null){
                return true;
            }
            return hasPathSum(root.left, targetSum - root.value) || hasPathSum(root.right, targetSum - root.value);
        }

        // Sum of root to leaf nodes.

        public int sumNumbers(TreeNode root){
            return helper(root, 0);
        }

        public int helper(TreeNode node, int sum) {
            if(node == null){
                return 0;
            }
            sum = sum * 10 + node.value;
            if (node.left == null && node.right == null) { // leaf node condition.
                return sum;
            }

            return helper(node.left, sum) + helper(node.right, sum);
        }

        //Binary Tree maximum path sum
        int maxSum = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root){
            helper(root);
            return maxSum;
        }
        public int helper(TreeNode node){
            if(node == null){
                return 0;
            }
            int left = Math.max(helper(node.left), 0);
            int right = Math.max(helper(node.right), 0);
            maxSum = Math.max(maxSum, left + right + node.value);
            return Math.max(left, right) + node.value;
        }

        // Path exists in a binary tree from root to leaf.

        public boolean findPath(TreeNode node, int[] arr, int index){
            if(node == null){
                return arr.length == 0;
            }
            return helper(node, arr, 0);
        }

        public boolean helper(TreeNode node, int[] arr, int index) {
            if(node == null){
                return false;
            }
            if(index >= arr.length || node.value != arr[index]){
                return false;
            }
            if(node.left == null && node.right == null && index == arr.length - 1){
                return true;
            }
            return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
            // index + 1 is used to move till the end element of the array.
        }
    }
}
