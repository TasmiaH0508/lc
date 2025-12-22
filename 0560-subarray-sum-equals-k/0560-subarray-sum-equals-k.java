class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefSum = new int[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefSum[i] = nums[i];
            if (i > 0) {
                prefSum[i] += prefSum[i - 1];
            }

            List<Integer> q = map.getOrDefault(prefSum[i], new LinkedList<>());
            q.add(i);
            map.put(prefSum[i], q);
        }

        int res = 0;
        for (int i = 0; i < prefSum.length; i++) {
            if (prefSum[i] == k) {
                res++;
            }
            // prefSum[i] - needed = k
            int needed = prefSum[i] -  k;
            if (map.containsKey(needed)) {
                List<Integer> indices = map.get(needed);
                for (int index : indices) {
                    if (index < i) {
                        res++;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}