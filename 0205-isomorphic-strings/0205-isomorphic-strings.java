class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Set<Character> mapped = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (map.containsKey(sArr[i])) {
                char mappedTo = map.get(sArr[i]);
                if (mappedTo != tArr[i]) {
                    return false;
                }
            } else {
                if (mapped.contains(tArr[i])) {
                    return false;
                }
            }
            map.put(sArr[i], tArr[i]);
            mapped.add(tArr[i]);
        }
        return true;
    }
}