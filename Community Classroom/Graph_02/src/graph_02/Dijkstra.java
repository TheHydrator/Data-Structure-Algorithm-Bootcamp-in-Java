package graph_02;

import java.util.*;

class pair {
    int node;
    int distance;
    public pair(int distance, int node){
        this.node = node;
        this.distance = distance;
    }
}
//User function Template for Java
class Dijkstra {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Create a priority queue for storing the nodes as a pair {distance, node}
        // where dist is the distance from source to the node.
        PriorityQueue<pair> pq =
                new PriorityQueue<pair>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V];

        // Initialising distTo list with a large number to
        // indicate the nodes are unvisited initially.
        // This list contains distance from source to the nodes.
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source initialised with dist=0.
        dist[S] = 0;
        pq.add(new pair(0, S));

        // Now, pop the minimum distance node first from the min-heap
        // and traverse for all its adjacent nodes.
        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            // Check for all adjacent nodes of the popped-out
            // element whether the prev dist is larger than current or not.
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                // If the current distance is smaller,
                // push it into the queue.
                if (dis + edgeWeight <  dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new pair(dist[adjNode], adjNode));
                }
            }
        }
        // Return the list containing the shortest distances
        // from source to all the nodes.
        return dist;
    }
}