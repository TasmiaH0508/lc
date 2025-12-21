class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cash = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                cash[0]++;
            } else if (bill == 10) {
                cash[1]++;
                cash[0]--;
            } else {
                cash[2]++;
                if (cash[1] > 0) {
                    cash[1]--;
                    cash[0]--;
                } else {
                    cash[0] -= 3;
                }
            }

            for (int i = 0; i < cash.length; i++) {
                if (cash[i] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}