class Solution {
    public int strStr(String haystack, String needle) {
        char[] hArr = haystack.toCharArray();
        char[] nArr = needle.toCharArray();

        int limit = hArr.length - nArr.length;
        for (int i = 0; i <= limit; i++) {
            boolean isMatch = true;
            for (int j = 0; j < nArr.length; j++) {
                if (hArr[i + j] != nArr[j]) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                return i;
            }
        }
        return -1;
    }
}