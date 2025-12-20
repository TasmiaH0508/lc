class Solution {
    public int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : arr) {
            int f = freq.getOrDefault(c, 0);
            f++;
            freq.put(c, f);
        }

        for (int i = 0; i < arr.length; i++) {
            int f = freq.get(arr[i]);
            if (f == 1) {
                return i;
            }
        }
        return -1;
    }
}