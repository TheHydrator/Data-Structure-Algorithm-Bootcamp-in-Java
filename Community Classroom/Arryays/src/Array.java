import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 4;
        arr[3] = 8;
        arr[4] = 9;
//        for (int i =0; i<5; i++){
//            arr[i] = in.nextInt();
//        }
        for (int num: arr){
            System.out.println(num + " ");
        }
        System.out.println(Arrays.toString(arr));
    }
}
