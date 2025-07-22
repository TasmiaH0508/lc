class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        int[] indexToNextSmallest = new int[nums.length];
        Set<Integer> hasNoBiggerConsecutiveNum = new HashSet<>();
        for (int num : numToIndex.keySet()) {
            int index = numToIndex.get(num);
            int nextSmallest = num - 1;
            int indexOfNextSmallest = numToIndex.getOrDefault(nextSmallest, -1);
            indexToNextSmallest[index] = indexOfNextSmallest;
            int nextBigger = num + 1;
            if (!numToIndex.containsKey(nextBigger)) {
                hasNoBiggerConsecutiveNum.add(num);
            }
        }

        int maxLen = 0;
        for (int bigNum : hasNoBiggerConsecutiveNum) {
            int startIndex = numToIndex.get(bigNum);
            int len = 0;
            while (startIndex != -1) {
                startIndex = indexToNextSmallest[startIndex];
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}