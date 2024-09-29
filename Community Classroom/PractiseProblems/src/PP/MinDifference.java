package PP;

public class MinDifference {
    int minDifference = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return minDifference;
        }
        getMinimumDifference(root.left);

        // process root
        if(prev != null){
            minDifference = Math.min(minDifference, root.val - prev);
        }

        prev = root.val;

        getMinimumDifference(root.right);

        return minDifference;
    }

}
