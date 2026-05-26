class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lowerCase = new HashSet<>();
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (c >= 97) {
                lowerCase.add(c);
            }
        }

        Set<Character> res = new HashSet<>();
        for (char c : arr) {
            boolean isUpper = c >= 65 && c <= 90;
            char lowC = (char)(c + 32);
            if (isUpper && lowerCase.contains(lowC)) {
                res.add(c);
            }
        }
        return res.size();
    }
}