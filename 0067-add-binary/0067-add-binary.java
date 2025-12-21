class Solution {
    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        char[] aArr = a.toCharArray();
        if (aArr.length < maxLen) {
            aArr = fillArr(aArr, maxLen);
        }

        char[] bArr = b.toCharArray();
        if (bArr.length < maxLen) {
            bArr = fillArr(bArr, maxLen);
        }

        int carryOver = 0;
        char[] res = new char[maxLen];
        for (int i = maxLen - 1; i >= 0; i--) {
            int a1 = aArr[i] - '0';
            int a2 = bArr[i] - '0';
            int total = a1 + a2 + carryOver;
            int curr = total % 2;
            carryOver = total / 2;

            if (curr == 0) {
                res[i] = '0';
            } else {
                res[i] = '1';
            }
        }

        StringBuilder sb = new StringBuilder();
        if (carryOver > 0) {
            sb.append('1');
        }

        for (char c : res) {
            sb.append(c);
        }

        return sb.toString();
    }

    private char[] fillArr(char[] arr, int maxLen) {
        char[] res = new char[maxLen];
        int j = arr.length - 1;
        for (int i = maxLen - 1; i >= 0; i--) {
            if (j < 0) {
                res[i] = '0';
            } else {
                res[i] = arr[j];
            }
            j--;
        }
        return res;
    }
}