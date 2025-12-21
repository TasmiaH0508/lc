class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned) {
            word = word.toLowerCase();
            bannedWords.add(word);
        }

        StringBuilder sb = new StringBuilder();
        char[] arr = paragraph.toCharArray();
        Map<String, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        String res = null;
        for (char c : arr) {
            boolean isPunc = c == ' ' || c == '!' || c == '?' || c == '\'' || c == ',' 
                                || c == ';' || c == '.';
            if (isPunc) {
                String word = sb.toString().toLowerCase();
                sb = new StringBuilder();
                if (!bannedWords.contains(word)) {
                    int f = freq.getOrDefault(word, 0) + 1;
                    freq.put(word, f);
                    if (f > maxFreq) {
                        res = word;
                        maxFreq = f;
                    }
                }
            } else {
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            String word = sb.toString().toLowerCase();
            if (!bannedWords.contains(word)) {
                int f = freq.getOrDefault(word, 0) + 1;
                if (f > maxFreq) {
                    res = word;
                }
            }
        }
        return res;
    }
}