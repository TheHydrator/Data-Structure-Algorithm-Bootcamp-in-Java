package BT;

import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        helper(root, minHeap, k);

        // remove k elements
        int ans = 0;
        for(int i=0; i<k; i++) {
            ans = minHeap.poll();
        }
        return ans;
    }

    private void helper(TreeNode node, PriorityQueue<Integer> minHeap, int k) {
        if (node == null) {
            return;
        }

        helper(node.left, minHeap, k);

        minHeap.offer(node.value);

        helper(node.right, minHeap, k);
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        TreeNode root  = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest.kthSmallest(root, 3));
    }
}
