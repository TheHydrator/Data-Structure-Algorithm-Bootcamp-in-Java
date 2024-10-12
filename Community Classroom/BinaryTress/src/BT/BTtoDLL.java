package BT;
public class BTtoDLL {
    LLNode head;
    LLNode tail;

    public TreeNode convert(TreeNode root){
        if(root == null){
            return null;
        }
        helper(root);

        return root;
    }

    private void helper(TreeNode node) {
        if(node == null){
            return;
        }
        // call the inorder traversal.
        helper(node.left);

        LLNode newNode = new LLNode(node.value);
        if(head == null) { // if the head is null, then create a new node.
            head = newNode; // created a new node of node value 1
            tail = newNode; // update the tail to the new node value 1.
        }else{
            tail.next = newNode; // tail.next = 2
            newNode.prev = tail; // 2.prev = 1
            tail = newNode; // update the tail to the new node value 2.
        }

        helper(node.right);
    }
}
// make a class for LinkedList.
class LLNode{
    int value;
    LLNode next;
    LLNode prev;

    public LLNode(int value){
        this.value = value;
    }
}

// make a class for TreeNode.
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }
}
