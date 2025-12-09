class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numPresent = new HashSet<>();
        for (int num : nums) {
            if (numPresent.contains(num)) {
                return true;
            } 
            numPresent.add(num);
        }
        return false;
    }
}