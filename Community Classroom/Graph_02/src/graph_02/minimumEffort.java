package graph_02;

import java.util.PriorityQueue;

public class minimumEffort {
    public int minimumEffortPath(int rows, int columns, int[][] heights){
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int n = heights.length;
        int m = heights[0].length;
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        // n * m
        while(!pq.isEmpty()){
            Tuple itr = pq.poll();
            int diff = itr.distance;
            int row = itr.row;
            int col = itr.col;
            // 4 directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (row == n - 1 && col == m - 1) {
                    return diff;
                }

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m){
                    int newEffort = Math.max(diff, Math.abs(heights[row][col] - heights[newRow][newCol]));
                    if(newEffort < distance[newRow][newCol]){
                        distance[newRow][newCol] = newEffort;
                        pq.add(new Tuple(newEffort, newRow, newCol));

                    }
                }
            }
        }
        return 0;
    }
}
class Tuple {
    int distance;
    int row;
    int col;

    public Tuple(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;

    }
}