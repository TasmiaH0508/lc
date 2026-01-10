class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        Deque<Character> d = new ArrayDeque<>();
        for (char c : arr) {
            if ((48 <= c && c <= 57) ||(97 <= c && c <= 122)) {
                d.addLast(c);
            }
        }

        while (d.size() > 0) {
            char first = d.pollFirst();
            char last = first;
            if (d.size() > 0) {
                last = d.pollLast();
            }

            if (first != last) {
                return false;
            }
        }
        return true;
    }
}