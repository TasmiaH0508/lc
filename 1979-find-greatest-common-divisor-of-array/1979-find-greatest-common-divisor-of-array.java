class Solution {
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int num : nums) {
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
        }

        int div = smallest;
        while (div > 0) {
            boolean isCommonDivisor = (smallest % div == 0) && (largest % div == 0);
            if (isCommonDivisor) {
                return div;
            }
            div--;
        }
        return div;
    }
}