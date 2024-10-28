import java.util.Arrays;

public class max2DValue {
    public static void main(String[] args) {
        int[][] arr = {
                {28, 23, 2345},
                {12, 13, 44, 45, 43},
                {1100, 32, 86, 7865},
                {1, 3, 34, 4,}
        };
//        int target = 4;
        int ans = max(arr); // format of return value {row, col}.
        System.out.println(Arrays.toString(new int[]{ans}));
    }
    static int max(int[][] arr){
        int max = Integer.MIN_VALUE;
        for (int[] elements : arr) {
            for (int col = 0; col < elements.length; col++) {
                if (elements[col] > max) {
                    max = elements[col];
                }
            }
        }

        return max;
    }
}
