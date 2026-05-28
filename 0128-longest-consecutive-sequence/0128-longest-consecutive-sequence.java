class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> present = new HashSet<>();
        for (int n : nums) {
            present.add(n);
        }

        Set<Integer> numWithNoSmallerNum = new HashSet<>();
        Map<Integer, Integer> numToBiggerNum = new HashMap<>();
        for (int p : present) {
            int smaller = p - 1;

            if (!present.contains(smaller)) {
                numWithNoSmallerNum.add(p);
            } else {
                numToBiggerNum.put(smaller, p);
            }
        }

        int maxLen = 0;
        for (int n : numWithNoSmallerNum) {
            int len = 1;

            int next = n;
            while (numToBiggerNum.containsKey(next)) {
                len++;
                next++;
            }

            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}