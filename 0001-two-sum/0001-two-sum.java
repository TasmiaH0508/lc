class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            if (numToIndex.containsKey(needed)) {
                int index = numToIndex.get(needed);
                return new int[]{index, i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[2];
    }
}