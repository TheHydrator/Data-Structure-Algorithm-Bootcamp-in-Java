public class binarySearch {
    public static void main(String[] args) {
    int[] arr = {-4, -2, 2, 4, 5, 6, 7, 8, 9, 10};
    int target = 10;
    int ans =BinarySearch(arr,target);
    System.out.println(ans);
    }
    //return the index.
    // return -1 if it does not exist.
    static int BinarySearch(int[]arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // find the middle element
            // this formula is used cause there might be a case where int value may exceed.
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

