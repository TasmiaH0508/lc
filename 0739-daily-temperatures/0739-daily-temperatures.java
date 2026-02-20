class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int daysToHigherTemp = 0;
            while (!s.empty()) {
                int[] top = s.peek();
                int topTemp = top[0];
                int day = top[1];

                if (topTemp > temperatures[i]) {
                    daysToHigherTemp = day - i;
                    break;
                } else {
                    s.pop();
                }
            }

            int[] arr = new int[]{temperatures[i], i};
            s.push(arr);

            res[i] = daysToHigherTemp;
        }
        return res;
    }
}