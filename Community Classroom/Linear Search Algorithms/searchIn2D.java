import java.util.Arrays;

public class searchIn2D {
    public static void main(String[] args) {
        int[][] arr = {
                {28, 23, 2345},
                {12, 13, 44, 45, 43},
                {1100, 32, 86, 7865},
                {1, 3, 34, 4,}
        };
        int target = 4;
        int[][] ans = search(arr,target); // format of return value {row, col}.
        System.out.println(Arrays.deepToString(ans));
    }
    static int[][]  search(int[][] arr, int target){
        for (int row= 0; row<arr.length; row++){
            for (int col = 0; col<arr[row].length; col++){
                if (arr[row][col] == target){
                    return new int[][] {{row},{col}};
                }
            }
        }

        return new int[0][0];
    }
}
