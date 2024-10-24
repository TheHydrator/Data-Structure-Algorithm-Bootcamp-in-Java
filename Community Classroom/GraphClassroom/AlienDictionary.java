package G2;

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) { // N - 1 because we are comparing the current word with the next word till the second last word.
            String s1 = dict[i];
            String s2 = dict[i + 1];
            for (int ptr = 0; ptr < Math.min(s1.length(), s2.length()); ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a'); // here subtract 'a' is done to get the index of the character.
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(K, adj); // here k is the number of characters in the alien dictionary and N is the number of words in the dictionary.
        String ans = "";
        for(int it : topo){
            ans = ans + (char)(it + (int)('a')); // here add 'a' is done to get the character from the index.
        }

        return ans;
    }

    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] inDegree =new int[V];
        for (int i = 0; i < V; i++) {
            for (int adjNode : adj.get(i)){
                inDegree[adjNode]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for (int adjNode : adj.get(node)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    q.add(adjNode);
                }
            }
        }
        return topo;
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int N = 5;
        int K = 4;
        System.out.println(alienDictionary.findOrder(dict, N, K));
    }
}
