package G1;

import java.util.*;

public class numberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'1', '0', '0', '1', '1'}
        };
        numberOfIslands obj = new numberOfIslands();
        System.out.println(obj.numIslands(grid));
    }
    //function to find the number of islands
    public int numIslands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if(!vis[row][col] && grid[row][col] == '1'){
                    bfs(grid, vis, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] vis, int ro, int co) {
        vis[ro][co] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        while(!queue.isEmpty()){
            Pair current  = queue.poll();
            int row = current.first; // what is current.first? row index of the current cell in the grid
            int col = current.second;

            // traverse the neighbors and mark them if is land and not visited.
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int newRow = row + delrow;
                    int newCol = col + delcol;
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                            !vis[newRow][newCol] &&grid[newRow][newCol] == '1'){
                        vis[newRow][newCol] = true;
                        queue.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }
}
class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}