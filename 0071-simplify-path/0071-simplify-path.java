class Solution {
    public String simplifyPath(String path) {
        Deque<String> directories = new ArrayDeque<>();
        char[] arr = path.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '/' && sb.length() > 0) {
                String name = sb.toString();
                if (name.equals("..") && directories.size() > 0) {
                    directories.pop();
                } else if (!name.equals(".") && !name.equals("..")) {
                    directories.push(name);
                }
                sb = new StringBuilder();
            } else if (arr[i] != '/') {
                sb.append(arr[i]);
            }
        }

        if (sb.length() > 0) {
            String name = sb.toString();
            if (name.equals("..") && directories.size() > 0) {
                directories.pop();
            } else if (!name.equals(".") && !name.equals("..")) {
                directories.push(name);
            }
        }

        StringBuilder res = new StringBuilder();
        res.append("/");
        while (directories.size() > 0) {
            String curr = directories.pollLast();
            res.append(curr);
            if (directories.size() > 0) {
                res.append("/");
            }
        }
        return res.toString();
    }
}