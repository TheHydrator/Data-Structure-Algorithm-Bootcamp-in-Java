package PP;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, (ArrayList<Integer>) ans);
        return ans;
    }

    private void inOrder(TreeNode node, ArrayList<Integer> ans) {
        if(node == null){
            return;
        }
        inOrder(node.left, ans);

        ans.add(node.val);

        inOrder(node.right, ans);
    }
}
