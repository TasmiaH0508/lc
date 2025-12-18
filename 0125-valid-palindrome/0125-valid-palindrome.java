class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            int a = c;
            if ((a >= 97 && a <= 122) || (a >= 48 && a <= 57)) {
                sb.append(c);
            }
        }

        String combined = sb.toString();
        char[] cArr = combined.toCharArray();
        int i = 0;
        int j = cArr.length - 1;
        while (i < j) {
            if (cArr[i] != cArr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}