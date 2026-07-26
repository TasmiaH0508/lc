class Solution {
    public int countVowelStrings(int n) {
        int numVowels = 5;
        int[] currLetterFreq = new int[numVowels];
        for (int i = 0; i < currLetterFreq.length; i++) {
            currLetterFreq[i]++;
        }

        for (int i = 1; i < n; i++) {
            int[] newLetterFreq = new int[numVowels];
            newLetterFreq[0] = currLetterFreq[0];
            for (int j = 1; j < newLetterFreq.length; j++) {
                newLetterFreq[j] = currLetterFreq[j] + newLetterFreq[j - 1];
            }
            currLetterFreq = newLetterFreq;
        }

        int res = 0;
        for (int f : currLetterFreq) {
            res += f;
        }
        return res;
    }
}