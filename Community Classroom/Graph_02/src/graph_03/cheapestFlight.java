package graph_03;

import java.util.*;

public class cheapestFlight {
    public int CheapestFLight(int n, int[][] flights, int src, int dst, int K){
        // Initialize adjacency-list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency-list with flight data
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // Initialize the queue for BFS
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        // Distance array to track the minimum cost to each node
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // BFS traversal
        while (!q.isEmpty()) {
            Tuple itr = q.poll();
            int stops = itr.stops;
            int node = itr.node;
            int cost = itr.cost;

            // Continue if the number of stops is within the allowed range
            if (stops <= K) {
                for (Pair iter : adj.get(node)) {
                    int adjNode = iter.node;
                    int edgeWeight = iter.distance;

                    // Update the cost and push the new state to the queue
                    if (cost + edgeWeight < distance[adjNode]) {
                        distance[adjNode] = cost + edgeWeight;
                        q.add(new Tuple(stops + 1, adjNode, cost + edgeWeight));
                    }
                }
            }
        }

        // If the destination node is unreachable, return -1
        if (distance[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return distance[dst];
    }

    public static void main(String[] args) {
        cheapestFlight solution = new cheapestFlight();
        int n = 3;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        int src = 0;
        int dst = 2;
        int k = 1;
        int result = solution.CheapestFLight(n, flights, src, dst, k);
        System.out.println(result); // Expected output: 200
    }
}

class Pair {
    int node;
    int distance;
    public Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}

class Tuple {
    int stops;
    int node;
    int cost;
    public Tuple(int stops, int node, int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}
