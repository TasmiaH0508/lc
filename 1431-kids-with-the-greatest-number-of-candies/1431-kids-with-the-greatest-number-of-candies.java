class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) {
            max = Math.max(c, max);
        }

        List<Boolean> res = new LinkedList<>();
        for (int c : candies) {
            int newCandies = c + extraCandies;
            boolean isMax = newCandies >= max;
            res.add(isMax);
        }
        return res;
    }
}