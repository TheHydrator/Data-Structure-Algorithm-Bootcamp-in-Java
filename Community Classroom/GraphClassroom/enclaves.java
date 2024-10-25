package G2;

import java.util.*;

class Combine {
    int first;
    int second;

    public Combine(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class enclaves {
    public int numberOfEnclaves(int[][] grid){
        Queue<Combine> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // first row, first col, last row, last col
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        q.add(new Combine(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            // traverses all the 4 directions.
            for (int i = 0; i < 4; i++) {
                int neighRow = row + delRow[i];
                int neighCol = col + delCol[i];
                if(neighRow >= 0 && neighRow < n && neighCol >= 0 && neighCol < m && vis[neighRow][neighCol] == 0 && grid[neighRow][neighCol] == 1){ // not visited as well as land that is 1.
                    q.add(new Combine(neighRow, neighCol));
                    vis[neighRow][neighCol] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if the land is not visited, and it is 1, then increment the count.
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }

        }
        return count++;
    }
}
