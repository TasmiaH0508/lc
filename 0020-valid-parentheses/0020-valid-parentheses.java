class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            boolean isOpening = c == '(' || c == '{' || c == '[';
            if (isOpening) {
                stack.push(c);
                continue;
            }

            char prev = '0';
            if (!stack.empty()) {
                prev = stack.peek();
            }

            boolean isMatch = (prev == '(' && c == ')') || 
                                (prev == '[' && c == ']') ||
                                (prev == '{' && c == '}');
            if (isMatch) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}