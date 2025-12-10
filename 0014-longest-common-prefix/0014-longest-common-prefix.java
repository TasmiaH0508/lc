class Solution {
    public String longestCommonPrefix(String[] strs) {
        char[] pref = null;
        for (int i = 1; i < strs.length; i++) {
            char[] prevArr = strs[i - 1].toCharArray();
            char[] currArr = strs[i].toCharArray();

            if (pref == null) {
                pref = initPref(prevArr, currArr, strs[i]);
            } else {
                pref = match(pref, prevArr);
                pref = match(pref, currArr);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] == '0') {
                break;
            } else {
                sb.append(pref[i]);
            }
        }
        return sb.toString();
    }

    private char[] match(char[] pref, char[] arr) {
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] == '0') {
                break;
            } else if (i >= arr.length || pref[i] != arr[i]) {
                pref[i] = '0';
                break;
            }
        }
        return pref;
    }

    private char[] initPref(char[] prevArr, char[] currArr, String str) {
        int j;
        for (j = 0; j < prevArr.length && j < currArr.length; j++) {
            if (prevArr[j] != currArr[j]) {
                break;
            }
        }
        String prefStr = str.substring(0, j);
        return prefStr.toCharArray();
    }
}