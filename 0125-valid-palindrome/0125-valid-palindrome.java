class Solution {
    public boolean isPalindrome(String s) {
        String ls = s.toLowerCase();
        char[] arr = ls.toCharArray();
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            boolean isLowLetter = (arr[low] >= 97 && arr[low] <= 122);
            boolean isLowNum = (arr[low] >= 48 && arr[low] <= 57);
            if (!isLowLetter && !isLowNum) {
                low++;
                continue;
            }

            boolean isHighLetter = arr[high] >= 97 && arr[high] <= 122;
            boolean isHighNum =  (arr[high] >= 48 && arr[high] <= 57);
            if (!isHighLetter && !isHighNum) {
                high--;
                continue;
            }

            if (arr[low] != arr[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}