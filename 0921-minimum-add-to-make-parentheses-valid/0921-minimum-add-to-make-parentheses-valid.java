class Solution {
    public int minAddToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int numClosing = 0;
        int res = 0;
        for (char c : arr) {
            if (c == ')' && numClosing == 0) {
                res++;
            } else if (c == ')' && numClosing > 0) {
                numClosing--;
            } else if (c == '(') {
                numClosing++;
            }
        }
        return res + numClosing;
    }
}