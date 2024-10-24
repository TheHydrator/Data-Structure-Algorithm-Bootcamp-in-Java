package G2;

import java.util.ArrayList;

public class BipartiteDFS {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);
        adj.get(0).add(3);
        BipartiteDFS obj = new BipartiteDFS();
        System.out.println(obj.isBipartite(V, adj));
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }
        // the above for loop is the same as the Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if(color[i] == -1){
                if(!dfs(i, 0, adj, color)) // if the graph is not bipartite.
                    return false;
             }
        }
        return true;
    }

    private boolean dfs(int node, int startCol, ArrayList<ArrayList<Integer>> adj, int[] color) {
        color[node] = startCol;

        for (int adjacentNode : adj.get(node)){
            // check for self-loops.
            if(color[adjacentNode] == startCol){
                return false;
            }
            if(color[adjacentNode] == -1){
                if(!dfs(adjacentNode, 1 - color[node], adj, color)) {
                    return false;
                } else if (color[adjacentNode] == startCol){
                    return false;
                }
            }
        }
        return true;
    }

}
