import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[]arr = {0, 1, 4, 20 ,2, 4, -99, 100};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            // find the max element in the arr and swap it with correct index.
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);

        }
    }
    static void swap(int[]arr, int first, int second ) {
        if(arr[first]>arr[second]) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
    }

    static int getMaxIndex(int[]arr, int start, int end){
        int max = start;
        //run a loop to find the max in the array.
        for (int i = start; i <= end; i++) {
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }

}
