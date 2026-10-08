class Solution {
    public String removeOuterParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> toDelete = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
                continue;
            }

            int lastOpening = stack.pop();
            if (stack.empty()) {
                toDelete.add(lastOpening);
                toDelete.add(i);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int curr = toDelete.peek();
            if (curr != i) {
                res.append(arr[i]);
            } else {
                toDelete.poll();
            }
        }
        return res.toString();
    }
}