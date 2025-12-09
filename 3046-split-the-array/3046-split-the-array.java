class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int f = 1;
            if (freqMap.containsKey(num)) {
                f += freqMap.get(num);
            }
            if (f > 2) {
                return false;
            }
            freqMap.put(num, f);
        }
        return true;
    }
}