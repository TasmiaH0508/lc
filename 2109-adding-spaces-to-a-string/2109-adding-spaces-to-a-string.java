class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j < spaces.length && spaces[j] == i) {
                sb.append(' ');
                j++;
            }

            sb.append(arr[i]);
        }
        return sb.toString();
    }
}