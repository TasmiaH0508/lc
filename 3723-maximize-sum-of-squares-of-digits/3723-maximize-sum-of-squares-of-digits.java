class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int numLeadingNines = sum / 9;
        int rem = sum % 9;
        int remLen = Math.min(rem, 1);
        int len = numLeadingNines + remLen;

        if (len > num) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (i < numLeadingNines) {
                res.append("9");
            } else if (i == numLeadingNines) {
                res.append("" + sum % 9);
            } else {
                res.append("0");
            }
        }
        return res.toString();
    }
}