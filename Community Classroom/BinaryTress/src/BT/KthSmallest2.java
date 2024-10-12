package BT;

public class KthSmallest2 {
    private int k;
    private int ans;
    public int kthSmallest(TreeNode root, int k){
        this.k = k;
        helper(root);
        return ans;
    }

    private void helper(TreeNode node) {
        if(node == null){
            return;
        }
        helper(node.left);
        k--;
        if(k == 0){
            ans = node.value;
            return;
        }
        helper(node.right);
    }

    public static void main(String[] args) {
        KthSmallest2 kthSmallest = new KthSmallest2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthSmallest.kthSmallest(root, 1));
    }
}
