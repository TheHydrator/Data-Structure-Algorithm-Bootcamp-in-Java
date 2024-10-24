package G2;
import java.util.*;

public class courseSchedule {
    static int[] findOrder(int n, int m, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] inDegree = new int[m];

        for (int i = 0; i < m; i++) {
            for (int adjNode : adj.get(i)){
                inDegree[adjNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        int[] topoArray = new int[n];
        int ind = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topoArray[ind++] = node;
            // node is in your topo sort, now remove all the edges from this node.
            for (int adjNode : adj.get(node)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    queue.add(adjNode);
                }
            }
        }

        if(ind == n){
            return topoArray;
        }

        // If there is a cycle, return an empty array
        return new int[]{};
    }
}
