class Solution {
    public String reverseVowels(String s) {
                boolean[] isVowel = new boolean[26];
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char v : vowels) {
            isVowel[v - 'a'] = true;
        }

        char[] sArr = s.toCharArray();
        String lwS = s.toLowerCase();
        char[] lArr = lwS.toCharArray();
        int low = 0;
        int high = lArr.length - 1;
        while (low <= high) {
            // check if it is a letter
            char lowChar = lArr[low];
            char highChar = lArr[high];
            boolean isLowLetter = (lowChar - 'a') >= 0 && (lowChar - 'a') < 26;
            boolean isHighLetter = (highChar - 'a') >= 0 && (highChar - 'a') < 26;

            boolean isLowVowel = false;
            if (isLowLetter) {
                isLowVowel = isVowel[lowChar - 'a'];
            }
            boolean isHighVowel = false;
            if (isHighLetter) {
                isHighVowel = isVowel[highChar - 'a'];
            }

            if (isLowVowel && isHighVowel) {
                char temp = sArr[low];
                sArr[low] = sArr[high];
                sArr[high] = temp;
                low++;
                high--;
            } else if (isLowVowel) {
                high--;
            } else if (isHighVowel) {
                low++;
            } else {
                low++;
                high--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : sArr) {
            sb.append(c);
        }
        return sb.toString();
    }
}