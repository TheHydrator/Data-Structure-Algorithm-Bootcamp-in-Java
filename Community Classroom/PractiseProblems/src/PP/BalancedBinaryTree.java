package PP;

// https://leetcode.com/problems/balanced-binary-tree/description/
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Height(root) != -1;// if the height is -1, then it is not balanced.
    }

    private int Height(TreeNode node) {
        if(node == null){
            return 0;
        }
        // get the height of the left subtree and right subtree.
        int leftHeight = Height(node.left);
        int rightHeight = Height(node.right);

        // now make a check for left subtree and right subtree, and if it is not balanced, then return -1 also check for the height difference.
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        // return the height of the tree.
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
