class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();

        for (String word : words) {
            char[] arr = word.toCharArray();

            int totalWeight = 0;
            for (char c : arr) {
                int index = c - 'a';
                totalWeight += weights[index];
            }

            int distanceFromZ = totalWeight % 26;
            int distanceFromA = 25 - distanceFromZ;
            char charToAdd = (char) ('a' + distanceFromA);
            res.append(charToAdd);
        }

        return res.toString();
    }
}