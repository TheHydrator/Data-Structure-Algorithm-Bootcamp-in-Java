import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }
    static int[] mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid)); // here the mid is exclusive.
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));// here the mid is inclusive.
        return merge (left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int  i = 0;
        int j = 0;
        int k = 0;
        while(i < first.length && j < second.length){
            if(first[i]<second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays of the arrays is not complete.
        // add all the remaining elements in the array.
        //copy the remaining elements.
        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while( j< second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }



    static void mergeSortInPlace(int[] arr, int start, int end){
        if (end - start == 1){
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSortInPlace(arr, start, mid); // here the mid is exclusive.
        mergeSortInPlace(arr, mid, end);// here the mid is inclusive.
        mergeInPlace(arr, start ,mid, end); // merge the two arrays.
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[ end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i < mid && j < end){
            if(arr[i]<arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }


        while(i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while( j< end){
            mix[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }
}
