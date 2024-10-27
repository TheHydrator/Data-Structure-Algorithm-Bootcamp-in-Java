package G2;

import java.util.*;

public class ShortestPath {
    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<pair1>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new pair1(v, wt));
        }
        // find the TopoSort
        int[] visited = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                topoSort(i, adj, visited, stack);
            }
        }
        // do the distance thing.
        int[] dist = new int[N];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (pair1 it : adj.get(node)) {
                int v = it.first;
                int wt = it.second;
                if (dist[node] != -1 && (dist[v] == -1 || dist[node] + wt < dist[v])) {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        return dist;
    }

    private void topoSort ( int node, ArrayList<ArrayList<pair1>>adj,int[] visited, Stack<Integer > stack){
        visited[node] = 1;
        for (pair1 it : adj.get(node)) {
            int v = it.first;
            if (visited[v] == 0) {
                topoSort(v, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}
class pair1{
    int first;
    int second;
    pair1(int v, int wt){
        this.first = v;
        this.second = wt;
    }
}
