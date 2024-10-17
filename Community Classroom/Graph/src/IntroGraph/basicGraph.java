package IntroGraph;


class Graph{
    void addEdge(int[][] adj, int u, int v){
        adj[u][v] = 1;
        adj[v][u] = 1;
    }
    int V(){
        return 0;
    }
    int E(){
        return 0;
    }
    Iterable<Integer> adj(int v){ // return the vertices adjacent to v.
        return null;
    }
}
public class basicGraph {
    // compute the maximum degree of the graph.
    public static int maxDegree(Graph G){
        int max = 0;
        int degree = 0;
        for (int v = 0; v < G.V(); v++) {
            if(degree(G,v) > max){
                max = degree(G,v);
            }
        }
        return max;

    }
    // compute the degree of v.
        private static int degree(Graph G, int v) {
        int degree = 0;
            for (int w : G.adj(v)) {
                degree++;
            }

            return degree;
    }

    // compute the average degree of the graph.
    public static double avgDegree(Graph G){
        return 2.0 * G.E() / G.V();
    }

    // compute the self-loops of the graph.
    public static int numberOfSelfLoops(Graph G){
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for(int w : G.adj(v)){
                if(v == w){
                    count++;
                }
            }
        }
        // each edge is counted twice.
        return count / 2;
    }
}
