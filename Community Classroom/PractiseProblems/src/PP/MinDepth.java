package PP;

import java.util.LinkedList;
import java.util.Queue;

//brute force approach.
public class MinDepth {
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        if(left == 0 || right == 0) {
            return Math.max(left,right) + 1;
        }
        return Math.min(left,right) + 1;
    }

    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int depth = 1;
        // create a queue for level order disorder.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // if a leaf node is found, then return the node
                if (node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
