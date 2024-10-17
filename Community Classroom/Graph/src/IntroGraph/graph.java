package IntroGraph;

public class graph {
    void addEdge(int[][] adj, int u, int v){
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

}
