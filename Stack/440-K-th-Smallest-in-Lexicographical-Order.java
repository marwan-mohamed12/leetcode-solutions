class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;  // Start counting from the first number
        
        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                // Move to the next sibling
                curr++;
                k -= steps;
            } else {
                // Drill down into the current prefix
                curr *= 10;
                k--;
            }
        }
        
        return curr;
    }

    // Count the number of steps/numbers between curr and next within the range [1, n]
    private long countSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
