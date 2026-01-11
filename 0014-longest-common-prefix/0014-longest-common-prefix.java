class Solution {
    public String longestCommonPrefix(String[] strs) {
        char[] prefArr = strs[0].toCharArray();

        for (int i = 1; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();

            for (int j = 0; j < prefArr.length; j++) {
                if (j >= arr.length) {
                    prefArr[j] = '0';
                } else {
                    if (arr[j] != prefArr[j]) {
                        prefArr[j] = '0';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : prefArr) {
            if (c == '0') {
                break;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}