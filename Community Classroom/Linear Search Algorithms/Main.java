public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 44, 45, 56, 778, 212};
        int target = 212;
        int ans = linearSearch(nums, target);
        System.out.println(ans);
    }

    //search in the array: return the index of item found
    //otherwise if item not found return -1.
    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

//        //run for a loop
        for (int index = 0; index < arr.length; index++) {
            //check for every element at every index if it is equal to target.
            int element = arr[index];
            if (element == target) {
                return index;
            }
            // This line will get executed if none of the elements had been found in the array
            //hence the return -1 will get displayed as -1(target not found)
        }
        return -1;
    }

}