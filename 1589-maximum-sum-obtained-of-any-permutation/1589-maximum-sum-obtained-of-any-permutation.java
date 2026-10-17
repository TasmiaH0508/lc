
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] diff = new int[nums.length + 1];
        for (int[] req : requests) {
            int start = req[0];
            int end = req[1];

            diff[start]++;
            diff[end + 1]--;
        }

        int[] freq = new int[diff.length - 1];
        int running = 0;
        for (int i = 0; i < freq.length; i++) {
            running += diff[i];
            freq[i] = running;
        }

        Arrays.sort(freq);
        Arrays.sort(nums);

        long res = 0;
        long mod = 1_000_000_007L;
        for (int i = 0; i < nums.length; i++) {
            res = (res + (long) nums[i] * freq[i]) % mod; // freq[i] can be an int
        }
        return (int) res;
    }
}