class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        Map<Integer, List<List<Integer>>> diffToElems = new HashMap<>();
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int absDiff = arr[i] - arr[i - 1];
            smallestDiff = Math.min(smallestDiff, absDiff);

            List<List<Integer>> ll = diffToElems.getOrDefault(absDiff, new LinkedList<>());
            List<Integer> curr = new LinkedList<>();
            curr.add(arr[i - 1]);
            curr.add(arr[i]);

            ll.add(curr);
            diffToElems.put(absDiff, ll);
        }

        List<List<Integer>> res = diffToElems.get(smallestDiff);

        return res;
    }
}