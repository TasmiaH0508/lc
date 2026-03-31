class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndex = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (charToIndex.containsKey(arr[i])) {
                start = Math.max(start, charToIndex.get(arr[i]) + 1);
            }

            int len = i - start + 1;
            maxLen = Math.max(maxLen, len);
            charToIndex.put(arr[i], i);
        }
        return maxLen;
    }
}