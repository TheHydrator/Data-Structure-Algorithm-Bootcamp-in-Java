import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[]arr = {3, 0, 1};
        missingNumber(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int missingNumber(int[] arr){
        int i = 0;
        while(i < arr.length ){
            int correctIndex = arr[i] ;
            if(arr[i]<arr.length && arr[i]!=arr[correctIndex]){
                swap(arr, i, correctIndex);
            }
            else{
                i++;
            }
        }

        // search for first missing number.
        for (int index = 0; index < arr.length; index++) {
            if(arr[index]!= index){
                return index;
            }
        }
        //case number 2
        return arr.length;
    }
    static void swap(int[]arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

