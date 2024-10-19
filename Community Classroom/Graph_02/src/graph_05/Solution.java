package graph_05;

import java.util.*;

public class Solution {
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>>edges, int S){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        // V * E time complexity
        for(int i= 0; i < V - 1; i++){
            for(ArrayList<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check for the negative cycle.
        for(ArrayList<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(3, 2, 6)));
        edges.add(new ArrayList<>(Arrays.asList(5, 3, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1 ,5, -3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, -2)));
        edges.add(new ArrayList<>(Arrays.asList(3 ,4, -2)));
        edges.add(new ArrayList<>(Arrays.asList(2 ,4, 3)));

        int S = 0;
        int[] res = bellman_ford(V, edges, S);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
