class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            boolean isOpening = arr[i] == '(' || arr[i] == '[' || arr[i] == '{';
            if (isOpening) {
                stack.push(arr[i]);
            } else {
                char prev = '0';
                if (!stack.empty()) {
                    prev = stack.peek();
                }

                boolean isMatch = (prev == '(' && arr[i] == ')') || 
                                    (prev == '[' && arr[i] == ']') ||
                                    (prev == '{' && arr[i] == '}');
                if (isMatch) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}