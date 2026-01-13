class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int low = 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                low = Math.max(map.get(arr[i]) + 1, low);
            }
            int len = i - low + 1;
            System.out.println(len);
            maxLen = Math.max(maxLen, len);
            map.put(arr[i], i);
        }
        return maxLen;
    }
}