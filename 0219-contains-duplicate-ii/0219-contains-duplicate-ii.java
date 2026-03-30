class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> appeared = new HashSet<>();
        int i = 0;
        for (; i <= k && i < nums.length; i++) {
            if (appeared.contains(nums[i])) {
                return true;
            }

            appeared.add(nums[i]);
        }

        for (; i < nums.length; i++) {
            int out = nums[i - k - 1];
            appeared.remove(out);

            if (appeared.contains(nums[i])) {
                return true;
            }
            appeared.add(nums[i]);
        }
        return false;
    }
}