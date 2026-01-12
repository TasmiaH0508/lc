class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gPtr = 0;
        int sPtr = 0;

        int count = 0;
        while (gPtr < g.length && sPtr < s.length) {
            if (s[sPtr] >= g[gPtr]) {
                count++;
                sPtr++;
                gPtr++;
            } else {
                sPtr++;
            }
        }
        return count;
    }
}