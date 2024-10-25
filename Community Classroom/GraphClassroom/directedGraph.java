package G2;

import java.util.*;
public class directedGraph {
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        directedGraph obj = new directedGraph();
        boolean ans = obj.isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");

    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V]; // it is initialized with 0
        int[] pathVis = new int[V]; // it is initialized with 0

        for (int i = 0; i < V; i++) {
            if(visited[i] == 0){
                if(dfsCheck(i, adj, visited, pathVis)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVis) {
        visited[node] = 1; // if it is visited, then mark it as 1
        pathVis[node] = 1; // if it is in the current path, then mark it as 1

        // traverse for adjacent nodes
        for (int adjNode : adj.get(node)){
            // if the node has a self-loop, then it is a cycle
            if(adjNode == node){
                return true;
            }
            // check for immediate backEdge(not including the current node).
            if (visited[adjNode] == 1 && pathVis[adjNode] == 1 && adjNode != node) {
                return true;
            }

            // when the node is not visited.
            if(visited[adjNode] == 0){
                if(dfsCheck(adjNode, adj, visited, pathVis)){
                    return true;
                }
                // if the node has been previously visited
                // But it has to be visited on the same path
                else if (pathVis[adjNode] == 1){
                    return true;
                }
            }
        }
        // remove the marked as 1 from the current/pathVis array
        pathVis[node] = 0;
        return false;
    }
}

