package countsort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort { // this is a stable sort algorithm.
    public static void countSort(int[] array){
        if(array ==  null || array.length <= 1){
            return;
        }
        int max = array[0]; // Find the maximum element in the array
        for(int nums : array){
            if(nums > max){ // If the current element is greater than the max element
                max = nums;
            }
        }

        int[] countArray = new int[max + 1]; // Create a count array of size max + 1.
        for (int num : array){
            countArray[num]++; // Count the frequency of each element in the array
        }
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while(countArray[i] > 0){
                array[index] = i; // Replace the element in the array with the sorted element
                index++;
                countArray[i]--;
            }
        }
    }
    // we can also create countSort using HashMap to store the frequency of each element in the array.

    public static void countSortHashMap(int[]arr){
        if(arr ==  null || arr.length <= 1){
            return;
        }
        int max = Arrays.stream(arr).max().getAsInt(); // Find the maximum element in the array.
        int min = Arrays.stream(arr).min().getAsInt(); // Find the minimum element in the array.

        // now MapOut the frequency of each element in the array.
        Map<Integer, Integer> countMap = new HashMap();
        for(int num : arr){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1); // if the num is not present, then add default 0 or else increments the value by 1
        }
        int index = 0;
        for(int i = min; i <= max; i++){ // start from minimum to maximum
            int count = countMap.getOrDefault(i, 0); // get the frequency of the element.
            for (int j = 0; j < count; j++) { // loop will run for the frequency for that element suppose 2 is 2 times in the array, then the loop will run 2 times in the array.
                arr[index] = i; // Replace the element in the array with the sorted element
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
//        countSort(array);
//        for (int num : array){
//            System.out.println(num + " ");
//        }
        countSortHashMap(array);
        System.out.println(Arrays.toString(array));
    }
}
