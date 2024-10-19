package graph_02;

import java.util.*;
public class wordLadder {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList){
        Queue<PAIR> q = new LinkedList<>();
        q.add(new PAIR(startWord, 1));
        Set<String> set = new HashSet<>();
        int len = wordList.length;
//        for (int i = 0; i < len; i++) {
//            set.add(wordList[i]);
//        }
        for(String word : wordList){
            set.add(word);
        }
        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().length;
            q.poll();
            if(word.equals(targetWord)){
                return steps;
            }
            // word = hat -> hot
            for(int i = 0; i < word.length(); i++){
                for (char ch = 'a'; ch <= 'z' ; ch++) {
                    char[]replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    // if it exists in the set, then add it to the queue
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new PAIR(replacedWord, steps + 1));
                    }
                }
            }
        }
        // if we couldn't find the target word, then return 0
        return 0;

    }
}
class PAIR {
    String word;
    int length;
    PAIR(String word, int length) {
        this.word = word;
        this.length = length;
    }
}