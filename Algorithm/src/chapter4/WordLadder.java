package chapter4;

import java.util.*;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return Integer.MAX_VALUE;
        }
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.add(start);
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    queue.offer(nextWord);
                    set.add(nextWord);
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}
