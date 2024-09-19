import java.util.*;

class Solution {
    // Memoization map to store results of subproblems
    private Map<String, List<Integer>> memo = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        // If the result for the current expression is already computed, return it
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Iterate through the expression and find operators
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // If the character is an operator, split the expression into two parts
            if (ch == '+' || ch == '-' || ch == '*') {
                // Recursively solve for the left and right parts
                List<Integer> leftPart = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightPart = diffWaysToCompute(expression.substring(i + 1));
                
                // Compute all combinations of results from the left and right parts
                for (int left : leftPart) {
                    for (int right : rightPart) {
                        if (ch == '+') {
                            result.add(left + right);
                        } else if (ch == '-') {
                            result.add(left - right);
                        } else if (ch == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        
        // Base case: if there are no operators, the expression is a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        // Store the result in the memoization map before returning
        memo.put(expression, result);
        
        return result;
    }
}
