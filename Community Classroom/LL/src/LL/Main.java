package LL;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LList list = new LList();

        list.insertFirst(3);
        list.insertFirst(5);
        list.insertFirst(9);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insert(7, 0);
        list.display();
//        list.display();
//        list.deleteFirst();
//        list.insertLast(22);
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(2));
//        list.display();
        list.insertRec(8, 2);
        list.display();

//        DLL list = new DLL();
//        list.insertFirst(8);
//        list.insertFirst(3);
//        list.insertFirst(5);
//        list.insertFirst(12);
//        list.insertLast(99);
//        list.display();
//        list.displayReverse();
//        list.insert(8,65);
//        list.displayReverse();

//        CLL list = new CLL();
//        list.insert(8);
//        list.insert(9);
//        list.insert(2);
//        list.insert(7);
//        list.display();
//        list.delete(2);
//        list.display();



    }
}
