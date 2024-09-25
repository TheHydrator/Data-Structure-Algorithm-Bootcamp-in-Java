package wordladder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

        if(args.length != 2){
            System.out.println("Please provide two words as input");
            return;
        }

        String filename = "src/words.txt";
        Set<String> words = readWordsFromFile(filename);

        String startWord = args[0];
        String endWord = args[1];

        long startTime = System.currentTimeMillis();
        List<String> path = findWordLadderPath(words, startWord, endWord);
        long graphTime = System.currentTimeMillis();

        System.out.println("Time taken to construct the graph: " + (graphTime - startTime) + " ms");

        if (path != null) {
            System.out.println("Path from " + startWord + " to " + endWord + ": " + path);
        } else {
            System.out.println("No path found from " + startWord + " to " + endWord);
        }
    }

    public static Set<String> readWordsFromFile(String filename) {
        Set<String> words = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public static List<String> findWordLadderPath(Set<String> words, String startWord, String endWord) {
        Map<String, List<String>> adjList = new HashMap<>();
        for (String word : words) {
            adjList.put(word, new ArrayList<>());
        }

        for (String word : words) {
            for (String neighbor : findNeighbors(word, words)) {
                adjList.get(word).add(neighbor);
            }
        }
        
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(Arrays.asList(startWord));
        visited.add(startWord);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String lastWord = path.get(path.size() - 1);

            if (lastWord.equals(endWord)) {
                return path;
            }

            List<String> neighborsList = adjList.getOrDefault(lastWord, Collections.emptyList());
            for (String neighbor : neighborsList) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }

        return null;
    }

    public static List<String> findNeighbors(String word, Set<String> words) {
        List<String> neighbors = new ArrayList<>();
        StringBuilder sb;

        // Change a character
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != word.charAt(i)) {
                    sb = new StringBuilder(word);
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if (words.contains(newWord)) {
                        neighbors.add(newWord);
                    }
                }
            }
        }

        // Add a character
        for (int i = 0; i <= word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                sb = new StringBuilder(word);
                sb.insert(i, c);
                String newWord = sb.toString();
                if (words.contains(newWord) && !newWord.equals(word)) {
                    neighbors.add(newWord);
                }
            }
        }

        // Remove a character
        for (int i = 0; i < word.length(); i++) {
            sb = new StringBuilder(word);
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if (words.contains(newWord)) {
                neighbors.add(newWord);
            }
        }

        return neighbors;
    }
}


