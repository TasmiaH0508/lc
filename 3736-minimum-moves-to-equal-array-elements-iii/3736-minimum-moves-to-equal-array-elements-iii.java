class Solution {
    public int minMoves(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int n : nums) {
            maxVal = Math.max(n, maxVal);
        }

        int res = 0;
        for (int n : nums) {
            res += (maxVal - n);
        }
        return res;
    }
}