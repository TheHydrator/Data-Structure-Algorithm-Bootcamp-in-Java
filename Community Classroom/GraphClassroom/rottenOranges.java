package G2;

import java.util.*;

public class rottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{0,1,2},
                        {0,1,2},
                        {1,1,1}};
        rottenOranges obj = new rottenOranges();
        System.out.println(obj.orangesRotting(grid));
    }
    public int orangesRotting(int[][]grid){
        int n = grid.length;
        int m  = grid[0].length;
        //n x m grid
        Queue<Pair> q = new LinkedList<>();
        //n x m grid
        int[][] vis = new int[n][m];
        // int countFresh = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j< m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0)); // here time is initialized with 0 and it will be updated in the while loop.
                    vis[i][j] = 1;
                }else {
                    vis[i][j] = 0;
                }
                // if(grid[i][j] == 1){
                // countFresh++;
            }

        }

        int time = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        // int count = 0;
        while(!q.isEmpty()){
            Pair current = q.poll();
            int row = current.first; // int r = q.peek().first;
            int col = current.second;// int c = q.peek().second;
            time = current.time; // int time = q.peek().time;
            // q.poll();
            time = Math.max(time, current.time);

            for (int i = 0; i < 4; i++) {
                int neighRow = row + delRow[i];
                int neighCol = col + delCol[i];
                if(neighRow >= 0 && neighRow < n && neighCol >= 0 && neighCol < m
                        && grid[neighRow][neighCol] == 1 && vis[neighRow][neighCol] == 0){
                    q.add(new Pair(neighRow, neighCol, time + 1));
                    vis[neighRow][neighCol] = 1; // mark as visited
                    grid[neighRow][neighCol] = 2; // mark as rotten
                    // count++
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // check of all the oranges are rotten or not.
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        // if (count != countFresh) return -1; // means not touched or converted to all rotten oranges.

        return time;
    }
}
class Pair {
    int first;
    int second;
    int time;
    public Pair(int first, int second, int time){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

