package G2;

import java.util.*;

public class Solution {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj){
        List<List<Integer>>adjRev = new ArrayList<>();
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            // i -> it
            // it -> i
            for(int it : adj.get(i)){
                adjRev.get(it).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0){
                // add i to the queue.
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);
            for (int adjNode : adjRev.get(node)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    queue.add(adjNode);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
