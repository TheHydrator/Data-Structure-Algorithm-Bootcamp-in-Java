public class MountainArray {
    public static void main(String[] args){

    }

    public int peakIndexInMountainArray(int[] arr) {
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


}
