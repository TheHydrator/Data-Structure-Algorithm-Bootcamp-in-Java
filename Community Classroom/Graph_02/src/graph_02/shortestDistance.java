package graph_02;

import java.util.*;

public class shortestDistance {
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<tuple> q = new LinkedList<>();
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[source[0]][source[1]] = 0;
        q.add(new tuple(0, source[0], source[1]));
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        // n * m
        while (!q.isEmpty()) {
            tuple itr = q.poll();
            int dis = itr.first;
            int row = itr.second;
            int col = itr.third;
            // 4 directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                        && grid[newRow][newCol] == 1 && dis + 1 < distance[newRow][newCol]) {
                    distance[newRow][newCol] = dis + 1;
                    if (newRow == destination[0] && newCol == destination[1]) {
                        return dis + 1;
                    } else {
                        q.add(new tuple(dis + 1, newRow, newCol));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
                {1,1,0,1},
                {1 ,1, 1,1},
                {1,1,0,0},
                {1,0,0,1}};
        int[] source = {0, 1};
        int[] destination = {2, 2};
        shortestDistance obj = new shortestDistance();
        System.out.println(obj.shortestPath(grid, source, destination));
    }
}

class tuple {
    int first;
    int second;
    int third;

    public tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
