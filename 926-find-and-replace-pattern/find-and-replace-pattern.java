import java.util.*;

class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {

        HashMap<Character, Character> wordToPattern = new HashMap<>();
        HashMap<Character, Character> patternToWord = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {

            char w = word.charAt(i);
            char p = pattern.charAt(i);

            // Check word -> pattern mapping
            if (wordToPattern.containsKey(w) &&
                wordToPattern.get(w) != p) {
                return false;
            }

            // Check pattern -> word mapping
            if (patternToWord.containsKey(p) &&
                patternToWord.get(p) != w) {
                return false;
            }

            wordToPattern.put(w, p);
            patternToWord.put(p, w);
        }

        return true;
    }
}