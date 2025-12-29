class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return Integer.MIN_VALUE;
        }

        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int[] arr = new int[coins.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + coinChange(coins, amount - coins[i]);
        }

        int min = Integer.MAX_VALUE;
        boolean isFeasible = false;
        for (int res : arr) {
            if (res > 0) {
                min = Math.min(min, res);
                isFeasible = true;
            }
        }

        if (!isFeasible) {
            min = -1;
        }

        map.put(amount, min);
        return min;
    }
}