import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {-89, 90, 11, -110, 0, 100};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr) {
        boolean swapped = false; // this condition because if swapped did not happen it will not do n times iteration.
        // return the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}