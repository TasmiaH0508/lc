class Solution {
    public List<String> commonChars(String[] words) {
        int numStrings = words.length;

        int[][] map = new int[numStrings][26];
        for (int i = 0; i < words.length; i++) {
            char[] cArr = words[i].toCharArray();
            for (char c : cArr) {
                map[i][c - 'a'] += 1;
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int minFreq = Integer.MAX_VALUE;
            for (int j = 0; j < numStrings; j++) {
                minFreq = Math.min(minFreq, map[j][i]);
            }

            char currLetter = (char) ('a' + i);
            for (int k = 0; k < minFreq; k++) {
                res.add("" + currLetter);
            }
        }
        return res;
    }
}