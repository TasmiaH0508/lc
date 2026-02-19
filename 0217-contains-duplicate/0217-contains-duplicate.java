class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> appeared = new HashSet<>();
        for (int n : nums) {
            if (appeared.contains(n)) {
                return true;
            }

            appeared.add(n);
        }
        return false;
    }
}