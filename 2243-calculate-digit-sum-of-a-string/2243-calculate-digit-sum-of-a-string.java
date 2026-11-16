class Solution {
    public String digitSum(String s, int k) {
        String s1 = s;
        while (s1.length() > k) {
            char[] arr = s1.toCharArray();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i += k) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    if (i + j >= arr.length) {
                        break;
                    }

                    int c = arr[i + j] - '0';
                    sum += c;
                }
                sb.append(sum);
            }
            
            s1 = sb.toString();
        }
        return s1;
    }
}