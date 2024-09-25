import java.util.Arrays;

import static java.util.Collections.swap;

public class Swap {
    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5, 6};
       // swap(arr, 4, 0);
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void reverse(int[] arr){
        int start = 0;
        int end  = arr.length -1;
        while(start<end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    static void swap(int[] arr, int index2, int index3){
        int temp = arr[index2];
        arr[index2] = arr[index3];
        arr[index3] =  temp;
    }
}
