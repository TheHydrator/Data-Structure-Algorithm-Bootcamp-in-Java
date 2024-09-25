import java.util.ArrayList;
import java.util.Scanner;
public class Arraylist {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(10);

//        list.add(12);
//        list.add(13);
//        list.add(11);
//        list.add(155);
//        list.add(24);
//
//        System.out.println(list);
//        list.set(0,99);
//        System.out.println(list);
//        list.remove(4);
//        System.out.println(list);
//        list.add(4,24);
//        System.out.println(list);

        for(int i = 0; i<5; i++){
            list.add(in.nextInt());
        }
        //get item at any index
        for(int i = 0; i<5; i++){
            System.out.println(list.get(i));// pass index here, list [index] syntax will not work here.
        }
//        System.out.println(list);

    }
}
