public class Flooring {
    public static void main(String[] args){
        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        int target = 11;
        int ans =orderAgnosticBS(arr,target);
        System.out.println(ans);
    }

    static int orderAgnosticBS(int[]arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        // finding the array if it is ascending or descending by boolean check.
        boolean isAsc = arr[start]<arr[end];

        while (start <= end) {
            // find the middle element
            // this formula is used cause there might be a case where int value may exceed.
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target<arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // If the target is greater than the greatest number in the array
            if (start < arr.length) {
                return start;
            } else {
                return -1; // Target is greater than the greatest number in the array
            }

        }
        return end;

    }
}
