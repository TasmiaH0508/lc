class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] arr1 = s1.toCharArray();
        for (char c : arr1) {
            int f = freq.getOrDefault(c, 0);
            f++;
            freq.put(c, f);
        }

        int windowSize = s1.length();
        char[] arr2 = s2.toCharArray();
        for (int i = 0; i + windowSize - 1 < arr2.length; i++) {
            Map<Character, Integer> freq2 = new HashMap<>();
            for (int j = 0; j < windowSize; j++) {
                int f = freq2.getOrDefault(arr2[i + j], 0);
                f++;
                freq2.put(arr2[i + j], f);
            }

            if (isSame(freq, freq2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(Map<Character, Integer> map, Map<Character, Integer> map2) {
        if (map.keySet().equals(map2.keySet())) {
            for (Character c : map2.keySet()) {
                int f = map.get(c);
                int f2 = map2.get(c);
                if (f != f2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}