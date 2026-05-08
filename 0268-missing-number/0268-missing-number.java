class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> present = new HashSet<>();
        for (int n : nums) {
            present.add(n);
        }

        int curr = 0;
        int max = nums.length;
        while (curr <= max) {
            if (!present.contains(curr)) {
                return curr;
            }
            curr += 1;
        }
        return -1;
    }
}