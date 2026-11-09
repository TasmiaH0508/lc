class Solution {
    public String smallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int[] letters = new int[26];

        int end = arr.length / 2;
        for (int i = 0; i < end; i++) {
            letters[arr[i] - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            int f = letters[i];
            char curr = (char)(i + 'a');

            for (int j = 0; j < f; j++) {
                res.append(curr);
            }
        }

        if (arr.length % 2 != 0) {
            res.append(arr[end]);
        }

        for (int i = letters.length - 1; i >= 0; i--) {
            int f = letters[i];
            char curr = (char)(i + 'a');

            for (int j = 0; j < f; j++) {
                res.append(curr);
            }
        }

        return res.toString();
    }
}