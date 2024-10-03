package LL;

class ListNode{
    int val;
     ListNode next;
    ListNode(int x) {
    val = x;
    next = null;
    }
    // cyclic linked list problem by two pointers method that is fast and slow pointer method
    // amazon and microsoft.
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
// amazon and microsoft.
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                // calculate the length.
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                return length;
            }
        }
        return 0;
    }

    public ListNode detectCycle(ListNode head) {
        int length = 0;
        // first detect the cycle.
        ListNode first = head;
        ListNode second = head;

        while(first != null && second.next != null) {
            first = second.next.next;
            second = second.next;
            if (first == second) {
                length = lengthCycle(second);
                break;
            }
        }
        if(length == 0){
            return null;
        }
        // find the start node.
        ListNode f = head;
        ListNode s = head;
        while(length > 0){
            s = s.next;
            length--;
        }
        // keep both moving forward, and they will meet at the cycle start node.
        while( f != s){
            f = f.next;
            s = s.next;
        }
        return s;
    }

    // happy number google question

    public boolean isHappy(int n){
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        if (slow == 1){
            return true;
        }
        return false;
    }

    private int findSquare(int number) {
        int ans = 0;

        while(number > 0){
            int rem = number % 10;
            ans = ans + rem * rem;
            number = number / 10;
        }
        return ans;
    }
 //https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class CLL {
    private Node head;
    private Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head; // Update the tail's next to point back to head for circularity
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.value + " -> "); // Print without a new line for better formatting
                node = node.next;
            } while (node != head);
        }
        System.out.print("HEAD");
    }

    public void delete(int value){
        Node node = head;
        if (node == null){
            return;
        }
        if(node.value == value){
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = node.next;
            if (n.value == value){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while (node != head);
        System.out.println();
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
