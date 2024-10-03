package LL;

public class LList {
    private Node head;
    private Node tail;
    private int size;

    public LList() {
        this.size = 0;
    }

    public void insertFirst(int val){ // insert the value at the first index of LinkedList
        Node node = new Node(val); // create a new node to insert at the first index.
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }
        size += 1;
    }

    // insert using recursion.
    public void insertRec(int value, int index){
        head = insertRec(value, index, head);
    }
    private Node insertRec(int value, int index, Node node){
        if(index == 0){
            Node temp = new Node(value, node);
            size++;
            return temp;
        }
        node.next = insertRec(value, index-1, node.next);
        return node;
    }

    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        return value;
    }

// Remove an element from a particular index and displaying it.
     public int delete(int index){
        if (index == 0){
            return deleteFirst();
        }
        if (index == size - 1){
            return deleteLast();
        }
        Node previous = get (index - 1);
        int value = previous.next.value;
        previous.next = previous.next.next; //  8 -> 9
         return value;
     }

    public Node find (int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get (int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst(){
        int value = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return value;
    }


    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size ++;
    }

    public void insert(int value, int index){
        if (index == 0){
            insertFirst(value);
            return;
        }
        if (index == size){
            insertLast(value);
            return;
        }
        Node temp = head; // 0th position is the head. and from starting i = 1 till the index value which we want to insert.
        for (int i = 1; i < index ; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public void display(){
        Node temp = head; // The temp itself is changing not the head node.
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // Questions.
    public void duplicates(){
        Node node = head;

        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

// merge question

    private static LList merge(LList first, LList second){ // two pointers
        Node f = first.head;
        Node s = second.head;

        LList ans = new LList();

        while(f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while ( f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    public static void main(String[] args) {
//        LList list = new LList();
//        list.insertLast(1);
//        list.insertLast(2);
//        list.insertLast(2);
//        list.insertLast(3);
//        list.insertLast(3);
//        list.display();
//        list.duplicates();
//        list.display();
        LList first = new LList();
        LList second = new LList();

        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);

        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(14);

        LList ans = LList.merge(first, second);
        ans.display();
    }

    // recursion reverse.
    private void reverse(Node node){
        if (node == tail){
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // in-Place Reversal LinkedList
    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return head;
    }

    // reverse a linked List-2
    //https://leetcode.com/problems/reverse-linked-list-ii/
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//
//    }

}

