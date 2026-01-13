class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int lastIndex = map.get(arr[i]);
                start = Math.max(lastIndex + 1, start);
            }

            map.put(arr[i], i);
            int len = i - start + 1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}