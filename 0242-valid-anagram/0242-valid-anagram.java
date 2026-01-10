class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        Map<Character, Integer> freq1 = new HashMap<>();
        for (char c : arr1) {
            int f = freq1.getOrDefault(c, 0) + 1;
            freq1.put(c, f);
        }

        char[] arr2 = t.toCharArray();
        Map<Character, Integer> freq2 = new HashMap<>();
        for (char c : arr2) {
            int f = freq2.getOrDefault(c, 0) + 1;
            freq2.put(c, f);
        }

        return freq1.equals(freq2);
    }
}