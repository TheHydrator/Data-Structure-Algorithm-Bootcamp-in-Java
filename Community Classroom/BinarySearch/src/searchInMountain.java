public class searchInMountain {
    public static void main(String[] args) {

    }
    int search(int[] arr, int target) {
        int peak = findInMountainArray(arr);
        int firstTry = orderAgnosticBS(arr, target, 0, peak);
        if (firstTry!=-1){
            return firstTry;
        }
        return orderAgnosticBS(arr, target, peak+1, arr.length-1);
    }
    public int findInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid]>arr[mid+1]){
                    // you are descending part of the array try to look at the left.
                    // this is why end != mid -1
                    end = mid;
            } else if (arr[mid]<arr[mid+1]) {
                start = mid +1;
            }
        }
            // in the end, start == end pointing to the largest number because of 2 checks above.
            // start and end always trying to find the max element in the above 2 checks.
            // Hence, when they point to the same element, the max element gets identified and that is what the checks say.
            return start;
        }

    static int orderAgnosticBS(int[]arr, int target, int start, int end) {
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
//            if (start < arr.length) {
//                return start;
//            } else {
//                return -1; // Target is greater than the greatest number in the array
//            }

        }
        return -1;

    }
}


//}
//
