class Solution {
    public int scoreOfString(String s) {
        char[] arr = s.toCharArray();

        int score = Math.abs(arr[0] - arr[1]);
        for (int i = 1; i < arr.length - 1; i++) {
            score += Math.abs(arr[i] - arr[i + 1]);
        }
        return score;
    }
}