class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder res = new StringBuilder();
        int rem = sum;
        for (int i = 0; i < num; i++) {
            int toSub = Math.min(9, rem);
            rem -= toSub;
            res.append("" + toSub);
        }
        if (rem != 0) {
            return "";
        }
        return res.toString();
    }
}