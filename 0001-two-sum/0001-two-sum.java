class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> ll = map.getOrDefault(nums[i], new LinkedList<>());
            ll.add(i);
            map.put(nums[i], ll);
        }

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                List<Integer> ll = map.get(needed);
                int neededIndex = ll.get(0);

                if (needed == nums[i]) {
                    if (ll.size() >= 2) {
                        neededIndex = ll.get(1);
                    } else {
                        continue;
                    }
                }

                int[] res = new int[]{i, neededIndex};
                return res;
            }
        }
        return null;
    }
}