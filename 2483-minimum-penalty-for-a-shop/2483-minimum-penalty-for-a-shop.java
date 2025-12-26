class Solution {
    public int bestClosingTime(String customers) {
        char[] arr = customers.toCharArray();
        int totalCustomers = 0;
        for (char c : arr) {
            if (c == 'Y') {
                totalCustomers++;
            }
        }

        int closingHour = 0;
        int minPenalty = totalCustomers;
        int penalty = minPenalty;
        for (int i = 1; i < arr.length; i++) {
            boolean hasCustomer = arr[i - 1] == 'Y';
            if (hasCustomer) {
                penalty--;
            } else {
                penalty++;
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                closingHour = i;
            }
        }

        if (arr[arr.length - 1] == 'Y') {
            penalty--;
        } else {
            penalty++;
        }

        if (penalty < minPenalty) {
            closingHour = arr.length;
        }
        
        return closingHour;
    }
}