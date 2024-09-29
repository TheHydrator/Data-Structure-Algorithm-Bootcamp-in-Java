package PP;

public class invertTree {
    public TreeNode InvertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = InvertTree(root.left);
        TreeNode right = InvertTree(root.right);
        // swap the nodes
        root.left = right;
        root.right = left;
        return root;
    }

}
