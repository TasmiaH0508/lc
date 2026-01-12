class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> appeared = new HashSet<>();
        for (int i : nums) {
            appeared.add(i);
        }

        int j = 1;
        List<Integer> res = new LinkedList<>();
        while (j <= n) {
            if (!appeared.contains(j)) {
                res.add(j);
            }
            j++;
        }
        return res;
    }
}