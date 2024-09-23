import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);  // Use a set for fast lookup
        }
        
        int[] dp = new int[n + 1];
        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            dp[i] = i;  // Start with assuming all characters are extra
        }
        
        dp[0] = 0;  // Base case: no extra characters in an empty string
        
        // DP to fill up the table
        for (int i = 1; i <= n; i++) {
            // Default case: treat s[0:i-1] as extra characters
            dp[i] = dp[i - 1] + 1;
            
            // Check if any dictionary word ends at position i
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dictSet.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        
        return dp[n];
    }
}
