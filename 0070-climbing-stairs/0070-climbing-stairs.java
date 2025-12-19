class Solution {
    Map<Integer, Integer> mem = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (mem.containsKey(n)) {
            return mem.get(n);
        }

        int oneStep = climbStairs(n - 1);
        int twoStep = climbStairs(n - 2);
        int res = oneStep + twoStep;
        mem.put(n, res);
        return res;
    }
}