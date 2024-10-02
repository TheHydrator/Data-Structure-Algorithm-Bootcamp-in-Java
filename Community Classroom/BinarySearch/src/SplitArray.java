public class SplitArray {
    public static void main(String[] args) {

    }
    public int[] splitArray(int[]nums, int m){
        int start = 0;
        int end = 0;

        for(int i = 0; i< nums.length; i++) {
            start = Math.max(start, nums[i]);// in the end of the loop this will contain the max item from the array.
            end = end + nums[i];//end+sum of all the values
        }
        //binary search
        while(start < end){
        // try for the middle as the potential answer
            int mid = start + (end - start) / 2;
            // calculate how many pieces you can divide this in with this max sum.
            int sum = 0;
            int pieces = 1;
            for (int num: nums){
                if (sum + num > mid){
                    // you cannot add this in this subarray, make a new one.
                    // say you add this num in the subarray, then sum = num
                    sum = num;
                    pieces++;
                }
                else {
                    start = sum + num;
                }
            }
            if (pieces > m){
                start = mid + 1;
            }
            else{
                end = mid;
            }

        }

        return new int[]{end};// here start == end
    }
}
