class Solution {
    public int arraySign(int[] nums) {
        boolean isZeroPresent = false;
        int numNeg = 0;
        for (int num : nums) {
            if (num == 0) {
                isZeroPresent = true;
            } else if (num < 0) {
                numNeg++;
            }
        }

        if (isZeroPresent) {
            return 0;
        } else if (numNeg % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}