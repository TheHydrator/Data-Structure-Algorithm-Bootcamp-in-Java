package G2;
import java.util.*;
class Node{
    int first;
    int second;
    int step;

    public Node(int first, int second, int step){
        this.first = first;
        this.second = second;
        this.step = step;
    }
}
public class nearestCell {

    public int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][]dist = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0}; // change in row
        int[] delCol = {0, 1, 0, -1}; // change in column.
        // n x m x 4
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col  = q.peek().second;
            int step = q.peek().step;
            q.poll();
            dist[row][col] = step;

            for (int i = 0; i < 4; i++) {
                int neighRow = row + delRow[i];
                int neighCol = col + delCol[i];

                if(neighRow >= 0 && neighRow < n && neighCol >= 0 && neighCol< m && vis[neighRow][neighCol] == 0){
                    vis[neighRow][neighCol] = 1;
                    q.add(new Node(neighRow, neighCol, step + 1));
                }

            }
            
        }
        return dist;
    }
}
