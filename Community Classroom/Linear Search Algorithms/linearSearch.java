public class linearSearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 44, 45, 56, 778, 212};
        int target = 212;
        boolean ans = linearSearch3(nums, target);
        System.out.println(ans);
    }

    static boolean linearSearch3(int[] arr, int target) {
        if (arr.length == 0) {
            return false;
        }
        for (int element : arr) {
            //check for every element at every index if it is equal to target.
            if (element == target) {
                return true;
            }
        }
        return false;
    }
}

