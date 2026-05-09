class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            int f = freq.getOrDefault(n, 0) + 1;
            freq.put(n, f);
        }

        int ptr = 0;
        int currVal = 0;
        while (ptr < nums.length) {
            int f = freq.getOrDefault(currVal, 0);
            for (int i = 0; i < f; i++) {
                nums[ptr + i] = currVal;
            }

            currVal++;
            ptr += f;
        }
    }
}