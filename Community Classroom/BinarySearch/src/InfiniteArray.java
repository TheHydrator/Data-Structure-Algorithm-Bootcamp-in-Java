public class InfiniteArray {
    public static void main(String[] args){
        int[] arr = {-3,0, 2, 4, 5, 6, 7, 8, 9, 10, 12, 13, 33, 44,56,
                67, 78, 89, 89, 99, 100, 111, 112, 115, 120, 121, 200, 212};
        int target = 10;
        System.out.println(ans(arr,target));
    }

    static int ans(int[] arr, int target){
        // first find the range and then find the box of size 2.
         int start = arr[0];
         int end = arr[1];
         // condition for the target to lie in the range.
         while(target>arr[end]) {
             int temp = end + 1; // this is my new start
             end = start + (end - start + 1) * 2;
             start = temp;
         }
            return BinarySearch(arr, target, start, end);
    }
    static int BinarySearch(int[]arr, int target, int start, int end) {

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
