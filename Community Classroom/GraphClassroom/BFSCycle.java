package G2;
import java.util.*;

class pair {
    int first;
    int second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class BFSCycle {
    private boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V, int src, boolean[] visited){
        visited[src] = true;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(src, -1));
        while(!q.isEmpty()){
            int node = q.peek().first; // (1, -1) here 1 is the node and -1 is the parent
            int parent = q.peek().second; // 1 is first and -1 is second
            q.poll();

            for(int adjacentNode : adj.get(node)){
                if(!visited[adjacentNode]){
                    visited[adjacentNode] = true;
                    q.add(new pair(adjacentNode, node));
                } else if (parent != adjacentNode){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                if(detectCycle(adj, V, i, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
