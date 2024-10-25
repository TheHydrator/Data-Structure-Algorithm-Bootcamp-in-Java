package G2;

import java.util.*;

public class distinctIslands {
    public int numDistinctIslands(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>(); // it stores the distinct islands.Only unique values are stored.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>();
                    // n x m x 4
                    dfs(i, j, vis, grid, vec, i, j); // Here i, j are the base co-ordinates.
                    set.add(vec); // but why do we use vector? It is used to store the path of the island.
                }
            }
        }
        // n x m x log(set.size()) + n x m x 4
        return set.size();
    }

    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> vec, int row0, int col0) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        // Carry the base co-ordinates. To subtract the base co-ordinates from the current co-ordinates.
        vec.add((row - row0) + " " + (col - col0)); // why is the "" used here? It is used to convert the integers to string.
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                dfs(nRow, nCol, vis, grid, vec, row0, col0);
            }
        }
    }
}
