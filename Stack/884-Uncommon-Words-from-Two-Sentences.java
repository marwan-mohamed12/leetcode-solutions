import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Step 1: Combine the two sentences into one string.
        String combined = s1 + " " + s2;
        
        // Step 2: Split the combined string into words.
        String[] words = combined.split(" ");
        
        // Step 3: Use a HashMap to count the frequency of each word.
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Step 4: Collect all words that appear exactly once.
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        // Step 5: Convert the result list to an array and return.
        return result.toArray(new String[0]);
    }
}
