package BT;

import org.w3c.dom.Node;

import java.util.Arrays;

public class DFS {
    private static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }
        TreeNode(){ } // default constructor
        public TreeNode(int value, TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

    // Diameter of a binary tree
        int diameter = 0;
        public int diameterOfBinaryTree(TreeNode node){
           height(node);
           return diameter - 1;
            }

        private int height(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            int dia = leftHeight + rightHeight + 1;

            diameter = Math.max(diameter, dia);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        // Invert a binary tree.

        public TreeNode invertTree(TreeNode root){
            if (root == null){
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            // swap the nodes now
            root.left = right;
            root.right = left;
            return root;
        }

        //Maximum Depth of Binary Tree
        public int maxDepth(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            int depth = Math.max(left, right) + 1;
            return depth;
        }

        //Convert Sorted Array to Binary Search Tree
        public TreeNode sortedArrayToBST(int[] nums){
            return sortedArrayToBST(nums, 0, nums.length);
        }

        TreeNode sortedArrayToBST(int[] nums, int start, int end){
            if(start >= end){ // but why? because we are using mid as the root node. So, if start == end, then there is no node to create.
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(nums, start, mid);
            node.right = sortedArrayToBST(nums, mid + 1, end);
            return node;
        }

        //Flatten the Binary Tree to linked-list.
        public void flatten(TreeNode root){
            if(root == null){
                return;
            }
            // Don't change the structure of the root node.
            TreeNode current = root;
            while(current != null){
                // check whether if the node has left subtree or not.
                if(current.left != null){
                    TreeNode temp = current.left;
                    while(temp.right != null){ // find the rightmost node of the left subtree which is empty.
                        temp = temp.right;
                    }
                    temp.right = current.right; // connect the right subtree to the rightmost node of the left subtree.
                    current.right = current.left; // connect the left subtree to the right subtree.
                    current.left = null; // make the left subtree null.
                }
                current = current.right;
            }
        }

        // Validate Binary Search Tree.

        public boolean isValidateBST(TreeNode root){
            return helper(root, null, null);
        }

        public boolean helper(TreeNode node, Integer low, Integer high) { // Integer wrapper class is used to handle null values.
            if (node == null) {
                return true;
            }
            if (low != null && value <= low) {
                return false;
            }
            if (high != null && value >= high) {
                return false;
            }
            boolean leftTree = helper(node.left, low, node.value);
            boolean rightTree  = helper(node.right, node.value, high);

            return leftTree && rightTree;
        }

        // Lowest Common Ancestor of a Binary Tree.
        // Time complexity is O(n) and Space complexity is O(log(N)) because of the height of the binary tree.

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
            if(root == null){
                return null;
            }
            if(root == p || root == q){
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left != null && right != null){ // if both left and right are not null, then the root is the LCA.
                return root;
            }
            return left != null ? left : right; // if left is not null, then return left, otherwise return right.
        }

        // Kth the smallest element in a BST.

        int count = 0;
         public int kthSmallest(TreeNode root, int k){
             return helper(root, k).value;
         }
         private TreeNode helper(TreeNode root, int k){
             if (root == null){
                 return null;
             }
             TreeNode left = helper(root.left, k); // traverse the left subtree.
             if(left != null){
                 return left; // found the kth smallest element.
             }
             count++; // increment the count till k.
             if(count == k){ // if the count is equal to k, then return the root node.
                 return root;
             }
             return helper(root.right, k); // traverse the right subtree if the count is not equal to k.
         }

         // Construct Binary Tree from Preorder and Inorder Traversal.

        public TreeNode buildTree(int[] preOrder, int[] inOrder){
             if(preOrder.length == 0 || inOrder.length == 0){
                 return null;
             }
             int r = preOrder[0]; // root node.
             int index = 0;
             for (int i = 0; i < inOrder.length; i++) {
               if(inOrder[i] == r){ // find the index of the root node in the inorder traversal.
                   index = i; // find the index of the root node in the inorder traversal.
               }
            }
            TreeNode node = new TreeNode(r); // create the root node.
            node.left = buildTree(Arrays.copyOfRange(preOrder, 1, index + 1) , Arrays.copyOfRange(inOrder, 0, index)); // create the left subtree.
            node.right = buildTree(Arrays.copyOfRange(preOrder, index +1, preOrder.length), Arrays.copyOfRange(inOrder, index + 1, inOrder.length )); // Create the right subtree.
            // Arrays.copyOfRange is used to create the subarray from the given array. It takes the start index and end index as the parameter. The start index is inclusive and the end index is exclusive.
            return node; // return the root node.
        }
    }
}
