public class RecursionSort {
    public static void main(String[] args) {
        int [] arr = {10, 2, 4, 5, 7, 10};
        System.out.println(sortedArr(arr, 0));
    }
    static boolean sortedArr(int[] arr, int index){
        //base condition.
        if(index == arr.length - 1){
            return true;
        }
        return arr[index] < arr[index + 1] && sortedArr(arr, index + 1);

    }
}
