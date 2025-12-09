class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] sCharArr = s.toCharArray();
        for (char c : sCharArr) {
            int f = 1;
            if (freq.containsKey(c)) {
                f = freq.get(c);
                f++;
            }
            freq.put(c, f);
        }

        char[] tCharArr = t.toCharArray();
        for (char c : tCharArr) {
            int f = freq.getOrDefault(c, -1);
            f--;
            if (f < 0) {
                return false;
            }
            freq.put(c, f);
        }

        for (char key : freq.keySet()) {
            int f = freq.get(key);
            if (f > 0) {
                return false;
            }
        }

        return true;
    }
}