class Solution {
    public int differenceOfSums(int n, int m) {
        int sum = n * (n + 1) / 2;
        int numTermsDivisibleByM = n / m;
        int num2 = numTermsDivisibleByM * (1 + numTermsDivisibleByM) * m / 2;
        int num1 = sum - num2;
        return num1 - num2;
    }
}