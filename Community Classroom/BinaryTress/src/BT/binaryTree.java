package BT;

import java.util.Scanner;

public class binaryTree {
    private static class Node{
        int value;
        Node left;
        Node right;

        // when you create a new node, initialize the value

        public Node(int value){
            this.value = value;
        }
    }
    private Node root;

    // insert elements
    public void populate(Scanner scanner){
        System.out.println("Enter the root node value: ");
        int value = scanner.nextInt();
        root = new Node(value); // call another recursion function from the root node that will fill the entire tree as desire.
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }


    public void display(){
        display(root, "");
    }
    private void display(Node node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left,  indent + "\t");
        display(node.right, indent +"\t");
    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        preOrder(root);
    }
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        preOrder(node.left);
        System.out.println(node.value + " ");
        preOrder(node.right);
    }

    public void postOrder(){
        preOrder(root);
    }
    private void postOrder(Node node){
        if (node == null){
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.value + " ");
    }

    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right, level + 1);
        if(level != 0){ // means the node is one or two level down. for that add that many spaces.
            for (int i = 0; i < level - 1; i++) {
                System.out.println("|\t\t");
            }
            System.out.println("|------>" + node.value);
        }else{
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        binaryTree tree = new binaryTree();
        tree.populate(scanner);
        tree.prettyDisplay();
    }
}
