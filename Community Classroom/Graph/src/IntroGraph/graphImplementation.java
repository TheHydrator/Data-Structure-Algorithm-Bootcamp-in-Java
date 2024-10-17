package IntroGraph;

import java.util.ArrayList;
import java.util.List;

public class graphImplementation {
    private final int V;
    private List<Integer> adj[];
    public graphImplementation(int V){
        this.V = V;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }
    public void addEdge(int w, int v){
        adj[w].add(v);
        adj[v].add(w);
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public static void main(String[] args) {

        graphImplementation G = new graphImplementation(5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(2,2); //if v == w then it is a self-loop.
        G.addEdge(0,3);
        G.addEdge(1,2);
        G.addEdge(1,3);
        G.addEdge(1,4);
        for (int v = 0; v < G.V; v++) {
            for (int w : G.adj(v)) {
                if(v<w) { // to avoid double counting, this condition is used.
                    System.out.println(v + "-" + w);
                }
            }
        }
    }
}
