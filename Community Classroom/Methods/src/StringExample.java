import java.util.Scanner;

public class StringExample {
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter your name: ");
//        String name = in.next();
//        String message = myGreet(name);
//        System.out.println(message);
//    }
//    static String myGreet(String name){
//        String greeting = "How are You? " + name;
//        return greeting;

        String name = "Rohit";
        greet(name);
        System.out.println("Hello " +name);
    }
    static String greet(String noName){
        noName = "Rahul Maity";//creating a new object inside the method, will not change the main function cause the strings are immutable.
        return(noName);
    }

}
