public class RBSUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        int target = 4;
        System.out.println(rotatedArraySearch(arr, target, 0, arr.length - 1));

    }
    static int rotatedArraySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (target == arr[mid]) {
            return mid;
        }

        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target <= arr[mid]) {
                return rotatedArraySearch(arr, target, start, mid - 1);
            } else {
                return rotatedArraySearch(arr, target, mid + 1, end);
            }
        }

        //if (arr[start] >= arr[mid]) {
        if (target >= arr[mid] && target <= arr[end]) {
            return rotatedArraySearch(arr, target, mid + 1, end);
        }
        return rotatedArraySearch(arr, target, start, mid - 1);

    }
}
