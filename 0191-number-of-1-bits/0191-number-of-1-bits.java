class Solution {
    public int hammingWeight(int n) {
        int val = 2;
        int count = 0;
        while (n > 0) {
            int rem = n % val;
            if (rem > 0) {
                n -= rem;
                count++;
            }
            val *= 2;
        }
        return count;
    }
}