package graph_02;

import java.util.*;

public class shortestPath {
    public int[] ShortestPath(int[][] edges, int n, int m, int src){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // here int n is the vertices
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]); // here int m is the undirected edge
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            for(int adjNode : adj.get(node)){
                if (dist[node] + 1 < dist[adjNode]){
                    dist[node] = dist[adjNode] + 1;
                    q.add(adjNode);
                }
            }
            // suppose we couldn't get to the destination then return the node with -1.
            for (int i = 0; i < n; i++) {
                if (dist[i] == Integer.MAX_VALUE){
                    dist[i] = -1;
                }
            }
        }
        return dist;
    }
}
