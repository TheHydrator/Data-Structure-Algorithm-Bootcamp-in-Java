package G1;

import java.util.*;

public class BFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> []graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    //DFS function
    public static void dfs(ArrayList<Edge> [] graph, int curr, boolean[]vis){
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }

        }
    }

    // BFS function
    public static void BFS(ArrayList<Edge> [] graph, int V, boolean []visited, int startNode){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startNode);

        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            if(!visited[currentNode]){
                System.out.print(currentNode + " ");
                visited[currentNode] = true;
                for (int i = 0; i < graph[currentNode].size(); i++) {
                    Edge e = graph[currentNode].get(i);
                    queue.offer(e.dest);
                }
            }
        }
    }

    // print all paths from source to destination
    public static void printAllPaths(ArrayList<Edge> []graph, boolean[]vis, int curr, String path, int target){
        if(curr == target){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            vis[curr] = true;
            if(!vis[e.dest]){
                vis[e.dest] = true;
                printAllPaths(graph, vis, e.dest, path + " -> " + e.dest, target);
                vis[e.dest] = false;
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;

        ArrayList<Edge> []graph = new ArrayList[V];
        createGraph(graph); // call the function to create the graph
        boolean []visited  = new boolean[V];
//        for (int i = 0; i < V; i++) { // if the graph is not connected means disconnected graph.
//            if(!visited[i]){ // if the node is not visited, then call BFS
//                dfs(graph, 0, visited);
//            }
//        }
        //dfs(graph, 0, visited);
        int src = 0;
        int target = 5;
        printAllPaths(graph, visited, src, "0", 5);
        System.out.println();

    }
}
