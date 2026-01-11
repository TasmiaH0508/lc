class Solution {
    public int[] plusOne(int[] digits) {
        int carryOver = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carryOver;
            digits[i] = sum % 10;
            carryOver = sum / 10;
        }

        if (carryOver != 0) {
            int[] arr = new int[digits.length + 1];
            arr[0] = carryOver;
            for (int i = 1; i < arr.length; i++) {
                arr[i] = digits[i - 1];
            }
            digits = arr;
        }
        return digits;
    }
}