package G2;

import java.util.*;

public class topological {
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                topodfs(i, adj, vis, stack);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i++] = stack.peek(); // what is ans[i++] means? It means first assign the value of stack.peek() to ans[i] and then increment i by 1.
            stack.pop();
        }
        return ans;
    }

    private static void topodfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stack) {
        vis[node] = 1;
        for (int adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                topodfs(adjNode, adj, vis, stack);
            }
        }
        stack.push(node);
    }
}
