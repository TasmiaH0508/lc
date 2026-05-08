class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }

        int rem = n;
        while (rem > 3) {
            if (rem % 3 != 0) {
                return false;
            }

            rem /= 3;
        }
        return rem == 3;
    }
}