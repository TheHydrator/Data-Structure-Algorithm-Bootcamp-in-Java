import java.util.Scanner;
import java.util.Arrays;
public class MultidimensionalArrays {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[3][];
        System.out.println(arr.length);
        //take input for individual arrays by initialising it.
        for (int i = 0; i< arr.length; i++){
            arr[i] = new int[]{in.nextInt()};
        }
/*        for (int row = 0; row<arr.length; row++){
            //now we take every row
            for (int col = 0; col<arr.length; col++){
                arr[row][col] = in.nextInt();
                System.out.print(arr[row][col]+ " ");
            }
            System.out.println();
        }*/
//        for (int row = 0; row<arr.length; row++){
//            System.out.println(Arrays.toString(arr[row]));
//        }
        for (int[]a: arr){
            System.out.println(Arrays.toString(a));
        }

    }
}
