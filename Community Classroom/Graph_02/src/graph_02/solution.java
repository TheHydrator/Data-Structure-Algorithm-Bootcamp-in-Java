package graph_02;

import java.util.*;

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> initialList = new ArrayList<>();
        initialList.add(startWord);
        queue.add(initialList);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;
        boolean foundTarget = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Track words used in this level
            List<String> currentLevelUsedWords = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                ArrayList<String> currentSequence = queue.poll();
                String lastWord = currentSequence.get(currentSequence.size() - 1);

                // Level management
                if (currentSequence.size() > level) {
                    level++;
                    for (String word : usedOnLevel) {
                        wordSet.remove(word);
                    }
                    usedOnLevel = new ArrayList<>(currentLevelUsedWords);
                }

                // Check if we have reached the target word
                if (lastWord.equals(targetWord)) {
                    foundTarget = true;
                    result.add(new ArrayList<>(currentSequence));
                    continue;
                }

                // Try all possible transformations
                for (int j = 0; j < lastWord.length(); j++) {
                    char[] charArray = lastWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charArray[j] = ch;
                        String nextWord = new String(charArray);

                        if (wordSet.contains(nextWord)) {
                            ArrayList<String> newSequence = new ArrayList<>(currentSequence);
                            newSequence.add(nextWord);
                            queue.add(newSequence);
                            currentLevelUsedWords.add(nextWord);
                        }
                    }
                }
            }

            // Break out of the loop if we have found the target word
            if (foundTarget) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        ArrayList<ArrayList<String>> sequences = solution.findSequences(startWord, targetWord, wordList);
        for (ArrayList<String> sequence : sequences) {
            System.out.println(sequence);
        }
    }
}
