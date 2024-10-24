package G2;

import java.util.*;

public class BipartiteBFS {
    private boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            for(int adjacentNode : adj.get(node)){
                // If the adjacent node is not yet colored.
                // Then color it with the opposite color of the current node.
                if(color[adjacentNode] == -1){
                    color[adjacentNode] = 1 - color[node];
                    q.add(adjacentNode);
                }
                // is the adjacent guy having the same color as the current node
                // someone did color it on some other path.
                else if(color[adjacentNode] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }
        //the above for loop same as the Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if(color[i] == -1){
                if(!check(i, V, adj, color)){ // if the graph is not bipartite.
                    return false;
                }
            }
        }
        return true;
    }
}
