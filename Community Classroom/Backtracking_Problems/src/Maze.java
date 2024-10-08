import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(count(3, 3));
//        path("", 3, 3);
//        System.out.println(pathRet("", 3, 3));
//        System.out.println(pathRetDiagonal("", 3, 3));
        boolean [][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };
        pathRestrictions("", board, 0 , 0);
    }

    static int count(int row, int column){
        // base condition.
        if(row == 1 || column == 1){
            return 1;
        }
        int left = count(row - 1, column);
        int right = count(row, column - 1);

        return left + right;
    }

    static void path(String p, int row, int column){
        // base condition
        if (row == 1 && column == 1){
            System.out.println(p);
            return;
        }
        if(row > 1){
            path(p +'D', row - 1, column);
        }
        if(column > 1){
            path(p + 'R', row, column - 1);
        }
    }

    static ArrayList<String> pathRet(String p, int row, int column){
        // base condition
        if (row == 1 && column == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if(row > 1){
            list.addAll(pathRet(p +'D', row - 1, column));
        }

        if(column > 1){
            list.addAll(pathRet(p + 'R', row, column - 1));
        }
        return list;
    }

    static ArrayList<String> pathRetDiagonal(String p, int row, int column){
        // base condition
        if (row == 1 && column == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(row > 1 && column > 1){
            list.addAll(pathRetDiagonal(p +'D', row - 1, column - 1));
        }

        if(row > 1){
            list.addAll(pathRetDiagonal(p +'V', row - 1, column));
        }

        if(column > 1){
            list.addAll(pathRetDiagonal(p + 'H', row, column - 1));
        }
        return list;
    }

    // maze with obstacles in between them.
    static void pathRestrictions(String p,boolean [][] maze, int row, int column){
        // base condition
        if (row == maze.length - 1 && column == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[row][column]){ //not false is true, then return.
            return;
        }
        if(row < maze.length - 1){
            pathRestrictions(p +'D', maze, row + 1, column);
        }
        if(column < maze[0].length - 1){
            pathRestrictions(p + 'R', maze, row, column + 1);
        }
    }



}
