public class RBS {
    public static void main(String[] args) {
    int[]arr = {6, 7, 0, 1, 2, 3, 4, 5};
    int target = 6;
    System.out.println(findPivotWithDuplicates(arr));
    }
     public int search(int[]nums, int target){
        int pivot = findPivotWithDuplicates(nums);
        // if you did not find the pivot that means the array is not rotated just do normal binary search.
        if (pivot == -1){
            return BinarySearch(nums, target, 0, nums.length-1);
        }
        //if pivot is found, you have 2 ascending sorted arrays.
         if(nums[pivot]==target){
            return pivot;
         }
         if(target>=nums[0]){ // here start = mums[0] is the start element in index 0.
             return  BinarySearch(nums, target, 0, pivot -1);
         }
         return BinarySearch(nums, target, pivot + 1, nums.length-1);
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

    static int findPivot(int[]arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            //4 cases
            if (mid<end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if (mid>start && arr[mid]<arr[mid-1]) {
                return mid -1;
            }
            if(arr[mid] <= arr[start]){
                end = mid -1;
            }else{
                start= mid +1;
            }

        }
        return -1;
    }
    // this will not work in duplicate values.
    static int findPivotWithDuplicates(int[]arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            //4 cases
            if (mid<end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if (mid>start && arr[mid]<arr[mid-1]) {
                return mid -1;
            }
            //if elements at middle, start, and end are equal then just skip the duplicates.
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
            // skip the duplicates.
            //NOTE: What if these elements at start and end were the pivot.
            // check if start is pivot
                if(arr[start]>arr[start+1]){
                    return start;
                }
                start++;

            // check whether end is pivot
                if(arr[end]<arr[end-1]){
                    return end - 1;
                }
                end--;

            // left side is sorted, so pivot should be in right
            }else if (arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid]>arr[end]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }

            }
        return -1;
    }
}
