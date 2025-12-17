class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >=0; i--) {
            boolean isFound = false;
            while (!s.empty()) {
                int[] curr = s.peek();
                if (curr[0] > temperatures[i]) {
                    res[i] = curr[1] - i;
                    isFound = true;
                    break;
                }
                s.pop();
            }

            if (!isFound) {
                res[i] = 0;
            }

            s.add(new int[]{temperatures[i], i});
        }
        return res;
    }
}