package BT;

public class segmentTree {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        segmentTree tree = new segmentTree(arr);
        tree.display();

        System.out.println(tree.query(1, 6));
    }
    private static class Node { // inner class
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node (int startInterval, int endInterval) { // constructor
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root; // root of the tree

    public segmentTree(int[] arr) {
        // create a tree using this array
        this.root = constructTree(arr, 0, arr.length - 1); // call the helper function
    }

    private Node constructTree(int[] arr, int start, int end) {
        if(start == end) {
            // leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // create new node with index you are at
        Node node = new Node(start, end);

        int mid = (start + end) / 2;

        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }
    private void display(Node node) {
        String str = "";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if(node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        // call recursion
        if(node.left != null) {
            display(node.left);
        }

        if(node.right != null) {
            display(node.right);
        }
    }

    // query
    public int query(int qsi, int qei) { // query start index, query end index
        return this.query(this.root, qsi, qei); // call the helper function
    }
    private int query(Node node, int qsi, int qei) {
        if(node.startInterval >= qsi && node.endInterval <= qei) {
            // the node is completely lying inside a query
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            // completely outside
            return 0;
        } else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei); // partial overlap
        }
    }

    // update
    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) { // if the index is in the range
            if(index == node.startInterval && index == node.endInterval) { // if the index is at the leaf node
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

}