class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (char c : arr) {
            if (c == ' ' && sb.length() > 0) {
                if (!stack.empty()) {
                    sb.append(' ');
                }
                String str = sb.toString();
                stack.push(str);
                sb = new StringBuilder();
            } else if (c != ' ') {
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            if (!stack.empty()) {
                sb.append(' ');
            }
            String str = sb.toString();
            stack.push(str);
        }

        StringBuilder sbRes = new StringBuilder();
        while (!stack.empty()) {
            String curr = stack.pop();
            sbRes.append(curr);
        }
        return sbRes.toString();
    }
}