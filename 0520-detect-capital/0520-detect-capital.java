class Solution {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        int startingCapIndex = -1;
        int numCap = 0;
        for (int i = 0; i < arr.length; i++) {
            int k = arr[i];
            boolean isCapital = k >= 65 && k <= 90;
            if (isCapital) {
                numCap++;
                if (startingCapIndex == -1) {
                    startingCapIndex = i;
                }
            }
        }
        
        boolean isValid = (startingCapIndex == 0 && (numCap == 1 || numCap == arr.length)) 
                            || (startingCapIndex == -1);
        return isValid;
    }
}