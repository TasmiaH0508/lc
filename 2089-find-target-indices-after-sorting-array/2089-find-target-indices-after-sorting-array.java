class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int currFreq = 0;
        int numsAppearingBefore = 0;
        for (int n : nums) {
            if (n < target) {
                numsAppearingBefore++;
            } else if (n == target) {
                currFreq++;
            } 
        }

        List<Integer> res = new LinkedList<>();
        int j = numsAppearingBefore;
        for (int i = 0; i < currFreq; i++) {
            res.add(j);
            j++;
        }
        return res;
    }
}