public class Maximum {
    public static void main(String[] args){
        int[] arr = {1, 7, 29, 39, 8, 4};
        System.out.println(maxRange(arr, 1, 4));
    }
    //for range values
    // work on edge cases here, like array being null.
    static int maxRange(int[] arr, int start, int end){
        if (end> start){
            return -1;
        }
        if (arr == null){
            return -1;
        }
        //imagine that arr is not empty. If not empty that take int maxVal = INTEGER.MIN_VALUE
        int maxVal = arr[0];
        for (int i = start; i <= end; i++){
            if(arr[i]> maxVal){
                maxVal = arr[i];
            }
        }
        return maxVal;
    }
    static int max(int[] arr){
        if (arr.length == 0){
            return -1;
        }
        //imagine that arr is not empty. If not empty that take int maxVal = INTEGER.MIN_VALUE
        int maxVal = arr[0];
        for (int i = 0; i < arr.length; i++){
            if(arr[i]> maxVal){
                maxVal = arr[i];
            }
        }
        return maxVal;
    }
}
