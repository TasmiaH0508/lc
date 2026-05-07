class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        char[] arr = s.toCharArray();

        int len = 0;
        if (arr[0] != ' ') {
            len++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != ' ') {
                if (arr[i - 1] == ' ') {
                    len = 1;
                } else {
                    len++;
                }
            }
        }
        return len;
    }
}