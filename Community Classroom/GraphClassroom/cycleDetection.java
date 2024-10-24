package G1;
import java.util.*;

public class cycleDetection {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));// Comment out the following line to test the case without a cycle

        graph[1].add(new Edge(1, 0));
    }

    public static boolean isCycleDetected(ArrayList<Edge>[] graph, boolean[] visited, boolean[] stack, int curr) {
        visited[curr] = true;
        stack[curr] = true; // It's an array to keep track of the nodes in the current recursion stack
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            // Explore further only if back edge is not encountered
            if (!visited[e.dest]) {
                if (isCycleDetected(graph, visited, stack, e.dest)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] visited = new boolean[V]; // To keep track of the visited nodes
        boolean[] rec = new boolean[V]; // To keep track of the nodes in the current recursion stack
        boolean isCycle = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleDetected(graph, visited, rec, i)) {
                    isCycle = true;
                    break;
                }
            }
        }
        System.out.println(isCycle);
    }
}
