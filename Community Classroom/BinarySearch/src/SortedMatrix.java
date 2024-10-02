import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(Search(arr,9)));
    }
    // search in the row provided between the col provided
    static int[] binarySearch(int[][]matrix, int row, int cStart, int cEnd, int target){
        while(cStart<=cEnd){
            int mid = cStart + (cEnd - cStart)/2;
            if (matrix[row][mid] == target){
                return new int[]{row, mid};
            }
            if (matrix[row][mid]<target){
                cStart = mid + 1;
            }else{
                cEnd = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
    static int[] Search(int[][]matrix, int target ){
        int rows = matrix.length;
        int cols = matrix[0].length;// be cautious over here, matrix me be empty
        if (rows == 1){
            return binarySearch(matrix, 0, 0, cols-1, target);
        }
        int rStart = 0;
        int rEnd = rows - 1;
        int midCol = cols/2;
        // run the loop till the 2 rows are remaining
        while(rStart < rEnd - 1){  // While this is true it will have more than 2 rows which we are trying to eliminate.
            int mid = rStart + (rEnd - rStart)/2;
            if(matrix[mid][midCol] == target){
                return new int[]{mid, midCol};
            }
            if(matrix[mid][midCol]<target){ // ignore the above rows.
                rStart = mid;
            }else{
                rEnd = mid;
            }
        }
        // now we have 2 rows
        // check whether the target is in the column of 2 rows.
        if (matrix[rStart][midCol] == target){
            return new int[]{rStart, midCol};
        }
        if (matrix[rStart+1][midCol]< target){// what is the end going to be?
            return new int[]{rStart + 1, midCol};
        }

        //otherwise, search in first half
        if(target <= matrix[rStart][midCol - 1]){
            return binarySearch(matrix, rStart, 0, midCol -1, target );
        }

        //search in second half
        if(target > matrix[rStart][midCol + 1]&& target<= matrix[rStart][cols - 1]){
            return binarySearch(matrix, rStart, midCol+1, cols-1, target);
        }
        //search in third half
        if(target <= matrix[rStart+1][midCol - 1]){
            return binarySearch(matrix, rStart+1, 0, midCol-1, target);
        }
        //search in fourth half
        else{                            //if(target >= matrix[rStart+1][midCol + 1]&& target<=matrix[rStart+1][cols-1]){
            return binarySearch(matrix, rStart+1, midCol+1, cols-1, target);
        }
    }

}

