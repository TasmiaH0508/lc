class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        res[res.length - 1] = 0;

        Stack<int[]> s = new Stack<>();
        int[] arr = new int[]{temperatures[temperatures.length - 1], temperatures.length - 1};
        s.push(arr);

        for (int i = res.length - 2; i >= 0; i--) {
            boolean found = false;
            int days = 0;
            while (!s.empty()) {
                int[] prev = s.peek();
                if (prev[0] > temperatures[i]) {
                    days = prev[1] - i;
                    break;
                } else {
                    s.pop();
                }
            }

            res[i] = days;

            int[] toAdd = new int[]{temperatures[i], i};
            s.push(toAdd);
        }
        return res;
    }
}