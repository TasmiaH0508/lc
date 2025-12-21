class Solution {
    public int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : arr) {
            int f = freq.getOrDefault(c, 0) + 1;
            freq.put(c, f);
        }

        int len = 0;
        for (char c : freq.keySet()) {
            int f = freq.get(c);
            if (len % 2 == 0) {
                len += f;
            } else {
                len += f - (f % 2);
            }
        }
        return len;
    }
}