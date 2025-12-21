class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int c = 0;
        int child = 0;
        int res = 0;
        while (c < s.length && child < g.length) {
            if (g[child] <= s[c]) {
                c++;
                child++;
                res++;
            } else {
                c++;
            }
        }
        return res;
    }
}