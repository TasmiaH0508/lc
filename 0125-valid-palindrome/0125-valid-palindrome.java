class Solution {
    public boolean isPalindrome(String s) {
        String sInLowerCase = s.toLowerCase();
        String sLetters = sInLowerCase.replaceAll("[^a-zA-Z0-9]", "");
        char[] arr = sLetters.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            char leftChar = arr[i];
            char rightChar = arr[j];
            if (leftChar != rightChar) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}