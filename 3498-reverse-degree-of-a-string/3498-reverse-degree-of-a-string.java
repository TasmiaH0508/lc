class Solution {
    public int reverseDegree(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int pos = 26 - (arr[i] - 'a');
            res += (i + 1) * pos;
        }
        return res;
    }
}