class Solution {
    /**
    for the parenthesis problem, we need to know which bracket closes which bracket

    for brackets, the closing bracket or the innermost have to be the closest -> we look at stack

    to decide if the brackets are the outermost, we can just check the size of the stack

    we can use a string builder as well...
    */
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