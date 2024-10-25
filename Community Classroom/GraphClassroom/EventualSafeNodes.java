package G2;

import java.util.*;
public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                dfsCheck(i, adj, vis, pathVis, check); // check for all the nodes that are safe.
                // here return true is not added cause, we want all the nodes to be dfs checked before we return the safe nodes.
            }
        }
        for (int i = 0; i < V; i++) {
            if(check[i] == 1){
                safeNodes.add(i);
            }

        }
        return safeNodes;
    }

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0; // initially mark all the safe nodes as 0.
        //traverse for adjacent nodes.
        for(int adjNode: adj.get(node)){
            // if the node has a self-loop, then it is a cycle.
            if(adjNode == node){
                check[node] = 0;
                return true;
            }
            // check for immediate backEdge(not including the current node).
            if(vis[adjNode] == 1 && pathVis[adjNode] == 1){
                check[node] = 0;
                return true;
            }
            // when the node is not visited.
            if(vis[adjNode] == 0){
                if(dfsCheck(adjNode, adj, vis, pathVis, check)){ 
                    check[node] = 0;
                    return true;
                }
            }
        }
        check[node] = 1; // if the node is safe, then mark it as 1.
        pathVis[node] = 0;
        return false;
    }
}
