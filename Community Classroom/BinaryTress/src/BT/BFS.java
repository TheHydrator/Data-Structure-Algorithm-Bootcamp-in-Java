package BT;

import java.util.*;

public class BFS {
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
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // while we are removing the node from the queue, we are adding the children of the node to the queue.
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize); // create a new list for each level.
            for(int i = 0; i < levelSize; i++){ // iterate through the current level
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.value); // add the value of the node to the current level list.
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
    public static void display(TreeNode node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left,  indent + "\t");
        display(node.right, indent +"\t");
    }
    public static void main(String[] args){
        BFS bfs = new BFS();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(11);
        System.out.println(bfs.levelOrder(root));
        BFS.display(root, "");
    }

    //average of level in Binary Tree
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double averageLevel = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // remove the node from the front of the queue.
                averageLevel = averageLevel + currentNode.value;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left); // add the left child to the queue. // if the node has no children, the queue will be empty.
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right); // add the right child to the queue. // if the node has no children, the queue will be empty.
                }
            }
            result.add(averageLevel / levelSize);

        }
        return result;
    }

    public TreeNode findSuccessor(TreeNode root, int key){
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNode currentNode = queue.poll();
            // for loop will not be used here because we are not adding the children of the node to the queue.
            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null){
                queue.offer(currentNode.right);
            }
            if(currentNode.value == key ){
                break;
            }
        }
        return queue.peek();
    }

    // Binary Tree zigzag level order traversal.

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i=0; i < levelSize; i++) {
                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst(); // remove the node from the front of the queue.
                    currentLevel.add(currentNode.value); // add the value of the node to the current level list.
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = queue.pollLast(); // remove the node from the end of the queue.
                    currentLevel.add(currentNode.value); // add the value of the node to the current level list.
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse; // toggle the reverse flag.// add the current level list to the result list.
            result.add(currentLevel);
        }
        return result;
    }

    //Binary Tree level order traversal II.

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // while we are removing the node from the queue, we are adding the children of the node to the queue.
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize); // create a new list for each level.
            for(int i = 0; i < levelSize; i++){ // iterate through the current level
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.value); // add the value of the node to the current level list.
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(0, currentLevel); // Add the current level list to the front of the result list. This will reverse the order of the levels.
        }
        return result;
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node leftMost  = root;
        while(leftMost.left != null){
            Node current = leftMost;
            while(current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
    }

    // Binary Tree Right side view

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // while we are removing the node from the queue, we are adding the children of the node to the queue.
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) { // iterate through the current level
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1) {
                    result.add(currentNode.value); // add the value of the node to the current level list.
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    //Cousins in Binary Tree.
    public boolean isCousins(TreeNode root, int x, int y){
        TreeNode xx = findNode(root, x); // find the node with value x // xx is the parent of x
        TreeNode yy = findNode(root, y); // find the node with value y // yy is the parent of y

        return (level(root, xx, 0) == level(root, yy, 0)) && (!isSiblings(root, xx, yy)); // check if the level of x and y are the same and they are not siblings.
    }
    TreeNode findNode(TreeNode node, int x){
        if(node == null){
            return null;
        }
        if(node.value == x){
            return node;
        }
        TreeNode n = findNode(node.left, x); // search the left subtree
        if(n != null){ // if the node is found in the left subtree, return the node.
            return n;
        }
       return findNode(node.right, x);  // search the right subtree
    }
    boolean isSiblings(TreeNode node, TreeNode x, TreeNode y){ // check if x and y are siblings.
        if(node == null){
            return false;
        }

        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) || isSiblings(node.left, x, y) || isSiblings(node.right, x, y)); // isSiblings(node.left, x, y) || isSiblings(node.right, x, y) will check if x and y are siblings in the left and right subtrees.
    }
    int level(TreeNode node, TreeNode x, int lev){
        if(node == null){
            return 0;
        }
        if(node == x ){ // if the node is x or y, return the level.
            return lev;
        }
         // try to search it in the left subtree
        int l = level(node.left, x, lev + 1);
        if(l != 0){
            return l;
        }
        return level(node.right, x,lev + 1); // try to search it in the right subtree
    }

    //Check whether a binary tree is a mirror of itself.

    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left); // add the left child of the root to the queue. // queue.offer(root) won't be added because it is only one.
        queue.add(root.right); // add the right child of the root to the queue.

        while(!queue.isEmpty()){
            TreeNode left = queue.poll(); // remove the node from the front of the queue.
            TreeNode right = queue.poll(); // remove the node from the front of the queue.
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.value != right.value){
                return false;
            }

            queue.add(left.left); // add the left child of the left node to the queue.
            queue.add(left.right); // add the right child of the left node to the queue.
            queue.add(right.right); // add the right child of the right node to the queue.
            queue.add(right.left); // add the left child of the right node to the queue.
        }
        return true;
    }

}
