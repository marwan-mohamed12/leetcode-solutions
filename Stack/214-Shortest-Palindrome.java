class Solution {
    public String shortestPalindrome(String s) {
        // Step 1: Create the reversed string
        String rev = new StringBuilder(s).reverse().toString();
        
        // Step 2: Concatenate the original string `s` with a separator and the reversed string
        String combined = s + # + rev;
        
        // Step 3: Compute the KMP partial match table (lps array)
        int[] lps = computeLPS(combined);
        
        // Step 4: Find the length of the longest palindromic prefix using the lps array
        int longestPalindromicPrefixLength = lps[lps.length - 1];
        
        // Step 5: Construct the shortest palindrome by appending the reverse of the non-palindromic part to the front
        String remaining = s.substring(longestPalindromicPrefixLength);
        String result = new StringBuilder(remaining).reverse().toString() + s;
        
        return result;
    }
    
    // KMP helper function to compute the lps (longest prefix suffix) array
    private int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        
        // Initialize pointers for KMP algorithm
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;
        
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Go back to the previous valid prefix
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
