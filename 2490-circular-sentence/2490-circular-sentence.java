class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        char[][] firstAndLastLetter = new char[words.length][2];
        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray();
            firstAndLastLetter[i][0] = arr[0];
            firstAndLastLetter[i][1] = arr[arr.length - 1];
        }

        for (int i = 1; i < words.length; i++) {
            char prevLastLetter = firstAndLastLetter[i - 1][1];
            char currStartLetter = firstAndLastLetter[i][0];

            if (prevLastLetter != currStartLetter) {
                return false;
            }
        }

        boolean firstMatchesLast = firstAndLastLetter[0][0] == firstAndLastLetter[words.length - 1][1];
        return firstMatchesLast;
    }
}