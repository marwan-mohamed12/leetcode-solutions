class Solution {
    public boolean isValid(String s) {

        if (s.length() < 2) {
            return false;
        }

        Stack<Character> validateString = new Stack<>();
        char[] sArray = s.toCharArray();
        
        for (char ch : sArray) {
            if (ch == '{' || ch == '[' || ch == '(' ) {
                validateString.push(ch);
            } else {
                if (ch == '}' || ch == ']' || ch == ')' ) {
                    if (validateString.isEmpty()) return false; 
                    char popElement = validateString.pop();
                    if (popElement != '{' && ch == '}' || popElement != '[' && ch == ']' ||
                        popElement != '(' && ch == ')') {
                            return false;
                        }
                }
            }
        }

        return validateString.isEmpty();

    }
}