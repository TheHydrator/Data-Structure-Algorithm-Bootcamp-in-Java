package G1;

import java.util.ArrayList;

public class findCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < V; j++) {
                adj.get(i).add(isConnected[i][j]);
            }
        }
        return numProvinces(adj, V);
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                dfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int current) {
        visited[current] = true;
        for (int i = 0; i <visited.length; i++) {
            if(adj.get(current).get(i) == 1 && !visited[i]) {
                dfs(adj, visited, i);
            }
        }
    }
}
