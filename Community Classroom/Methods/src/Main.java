import java.util.Scanner;

public class Main {
    //Q. Take input of 2 numbers and print the sum
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number 1:");
        int n1 = in.nextInt();
        System.out.print("Enter number 2: ");
        int n2 = in.nextInt();
        int n = n1 + n2;
        System.out.println("The sum is = " + n);
    }
}
