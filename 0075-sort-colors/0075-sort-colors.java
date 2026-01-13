class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int f = map.getOrDefault(i, 0) + 1;
            map.put(i, f);
        }

        int j = 0;
        for (int i = 0; i < 3; i++) {
            int f = map.getOrDefault(i, 0);
            for (int k = 0; k < f; k++) {
                nums[j] = i;
                j++;
            }
        }
    }
}