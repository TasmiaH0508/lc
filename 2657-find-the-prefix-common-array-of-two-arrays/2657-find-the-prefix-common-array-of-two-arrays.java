class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        Map<Integer, Integer> unmatchedA = new HashMap<>();
        Map<Integer, Integer> unmatchedB = new HashMap<>();
        // prepare the first index
        if (A[0] == B[0]) {
            res[0] = 1;
        } else {
            unmatchedA.put(A[0], 1);
            unmatchedB.put(B[0], 1);
        }

        for (int i = 1; i < res.length; i++) {
            if (A[i] == B[i]) {
                res[i] = res[i - 1] + 1;
                continue;
            } 

            int currMatches = 0;

            int fA = unmatchedB.getOrDefault(A[i], 0);
            if (fA > 0) {
                currMatches++;
                fA--;
                unmatchedB.put(A[i], fA);
            } else {
                int currFA = unmatchedA.getOrDefault(A[i], 0) + 1;
                unmatchedA.put(A[i], currFA);
            }

            int fB = unmatchedA.getOrDefault(B[i], 0);
            if (fB > 0) {
                currMatches++;
                fB--;
                unmatchedB.put(B[i], fB);
            } else {
                int currFB = unmatchedB.getOrDefault(B[i], 0) + 1;
                unmatchedB.put(B[i], currFB);
            }

            res[i] = currMatches + res[i - 1];
        }
        return res;
    }
}