import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTheLongestSubstring(String s) {
        // Map to store the first occurrence of a specific bitmask
        Map<Integer, Integer> bitmaskIndexMap = new HashMap<>();
        bitmaskIndexMap.put(0, -1); // Base case: bitmask 0 at index -1

        int bitmask = 0; // To track the parity of vowels
        int maxLength = 0;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Update the bitmask based on the current character
            if (c == 'a') {
                bitmask ^= (1 << 0); // Toggle bit 0 for 'a'
            } else if (c == 'e') {
                bitmask ^= (1 << 1); // Toggle bit 1 for 'e'
            } else if (c == 'i') {
                bitmask ^= (1 << 2); // Toggle bit 2 for 'i'
            } else if (c == 'o') {
                bitmask ^= (1 << 3); // Toggle bit 3 for 'o'
            } else if (c == 'u') {
                bitmask ^= (1 << 4); // Toggle bit 4 for 'u'
            }

            // If this bitmask was seen before, calculate the substring length
            if (bitmaskIndexMap.containsKey(bitmask)) {
                maxLength = Math.max(maxLength, i - bitmaskIndexMap.get(bitmask));
            } else {
                // Otherwise, store the first occurrence of this bitmask
                bitmaskIndexMap.put(bitmask, i);
            }
        }

        return maxLength;
    }
}
