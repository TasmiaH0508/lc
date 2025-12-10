class Solution {
    public int maxDistance(int[] colors) {
        int forwardDist = 0;
        for (int i = colors.length - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                forwardDist = i;
                break;
            }
        }
        
        int backwardDist = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[colors.length - 1]) {
                backwardDist = colors.length - 1 - i;
                break;
            }
        }
        return Math.max(forwardDist, backwardDist);
    }
}