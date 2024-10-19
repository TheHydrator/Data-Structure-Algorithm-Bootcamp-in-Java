//package graph_02;
//
//import java.util.*;
//
//public class printPath{
//    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
//        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int i = 0; i < m; i++) {
//            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
//            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
//        }
//
//        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
//        int[] dist = new int[n + 1]; // from 1 to n, hence size n+1
//        int[] parent = new int[n + 1]; // from 1 to n, hence size n+1
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        for (int i = 1; i <= n; i++) {
//            parent[i] = i;
//        }
//
//        dist[1] = 0;
//        pq.add(new Pair(0, 1)); // distance 0, node 1
//
//        while (!pq.isEmpty()) {
//            Pair it = pq.peek();
//            int dis = it.distance;
//            int node = it.node;
//            pq.poll();
//
//            for (Pair iter : adj.get(node)) {
//                int adjNode = iter.node;
//                int edgeWeight = iter.distance;
//
//                if (dis + edgeWeight < dist[adjNode]) {
//                    dist[adjNode] = dis + edgeWeight;
//                    parent[adjNode] = node;
//                    pq.add(new Pair(dist[adjNode], adjNode));
//                }
//            }
//        }
//
//        List<Integer> path = new ArrayList<>();
//        if (dist[n] == Integer.MAX_VALUE) {
//            path.add(-1);
//            return path;
//        }
//        // backtracking the path // O(n) + E log V
//        int node = n;
//        while (parent[node] != node) {
//            path.add(node);
//            node = parent[node];
//        }
//        path.add(1);
//        Collections.reverse(path);
//        return path;
//    }
//
//    public static void main(String[] args) {
//        int n = 5;
//        int m = 6;
//        int[][] edges = {{1, 2, 2}, {1, 3, 4}, {2, 3, 1}, {2, 4, 7}, {3, 5, 3}, {4, 5, 2}};
//        List<Integer> path = shortestPath(n, m, edges);
//        for (int i : path) {
//            System.out.print(i + " ");
//        }
//    }
//}
//
//
