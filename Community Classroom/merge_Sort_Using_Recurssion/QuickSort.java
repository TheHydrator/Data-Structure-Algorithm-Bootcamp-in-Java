import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] num, int low, int high){
        // base condition.
        if (low >= high){
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s) / 2; // here middle is the pivot.
        int pivot =num[m];


        while(s <= e){
            // also a reason if it is already sorted it will not swap.
            while(num[s] < pivot) {
                s++;
            }
            while(num[e] > pivot) {
                e--;
            }
        // this if condition is given for the line number 15 to not violate the condition.
            if (s <= e){
                int temp = num[s];
                num[s] = num[e];
                num[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now.
        sort(num, low, e);
        sort(num, s, high);

    }
}
