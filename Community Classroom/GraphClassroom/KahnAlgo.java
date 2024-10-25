package G2;

import java.util.*;

public class KahnAlgo {
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++){
            for (int adjNode : adj.get(i)){
                inDegree[adjNode]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int[] topo = new int[V];
        int i = 0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            topo[i++] = node;
            // node is in your topo sort, now remove all the edges from this node.

            for(int adjNode : adj.get(node)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    queue.add(adjNode);
                }
            }
        }
        return topo;
    }
}
