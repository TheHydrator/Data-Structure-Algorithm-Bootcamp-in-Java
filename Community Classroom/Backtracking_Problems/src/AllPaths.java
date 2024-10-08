import java.util.Arrays;
public class AllPaths {
    public static void main(String[] args) {
        boolean [][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };
//        allPathAvailable(" ", board, 0 , 0);
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("", board, 0,0, path, 1);

    }

    static void allPathAvailable(String p,boolean [][] maze, int row, int column){
        // base condition
        if (row == maze.length - 1 && column == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(!maze[row][column]){ //not false is true, then return.
            return;
        }
        // I am considering this block in my path.
        maze[row][column] = false;

        if(row < maze.length - 1){
            allPathAvailable(p +'D', maze, row + 1, column);
        }
        if(column < maze[0].length - 1){
            allPathAvailable(p + 'R', maze, row, column + 1);
        }
        if(row>0){
            allPathAvailable(p + 'U', maze, row - 1, column);
        }
        if(column > 0){
            allPathAvailable(p + 'L',maze,  row, column - 1);
        }
        // this line is where the function will be over.
        //so before the function gets removed, also remove the changes that were made by that function

        maze[row][column] = true;
    }



    static void allPathPrint(String p,boolean [][] maze, int row, int column, int [][] path, int step){
        // base condition
        if (row == maze.length - 1 && column == maze[0].length - 1){
            path[row][column] = step; // last step is also a step
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr)); // print the path
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[row][column]){ //not false is true, then return.
            return;
        }
        // I am considering this block in my path.
        maze[row][column] = false;
        path[row][column] = step;
        if(row < maze.length - 1){
            allPathPrint(p +'D', maze, row + 1, column, path, step + 1);
        }
        if(column < maze[0].length - 1){
            allPathPrint(p + 'R', maze, row, column + 1, path, step + 1);
        }
        if(row>0){
            allPathPrint(p + 'U', maze, row - 1, column, path, step + 1);
        }
        if(column > 0){
            allPathPrint(p + 'L',maze,  row, column - 1, path, step + 1);
        }
        // this line is where the function will be over.
        //so before the function gets removed, also remove the changes that were made by that function

        maze[row][column] = true;
        path[row][column] = 0;
    }
}
