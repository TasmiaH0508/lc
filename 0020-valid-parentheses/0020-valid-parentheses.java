class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            boolean isClosing = arr[i] == ')' || arr[i] == '}' || arr[i] == ']';
            if (!isClosing) {
                stack.push(arr[i]);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    char prev = stack.pop();
                    boolean isMatch = (arr[i] == ')' && prev == '(') 
                                    || (arr[i] == '}' && prev == '{') 
                                    || (arr[i] == ']' && prev == '[');
                    if (!isMatch) {
                        return false;
                    }
                }
            }
        }

        return stack.empty();
    }
}