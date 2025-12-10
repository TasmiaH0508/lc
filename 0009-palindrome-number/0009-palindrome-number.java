class Solution {
    public boolean isPalindrome(int x) {
        boolean isNegative = (x * -1) > 0;
        if (isNegative || x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return false;
        }

        int n = 10;
        Queue<Integer> digits = new LinkedList<>();
        int y = x;
        while (y != 0) {
            int digit = y % n;
            y /= n;
            digits.add(digit);
        }

        int newNum = 0;
        while (digits.size() > 0) {
            int digit = digits.poll();
            newNum += digit * Math.pow(10, digits.size());
        }

        return newNum == x;
    }
}