class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        Map<Integer, List<List<Integer>>> diffToElems = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            int absDiff = arr[i] - arr[i - 1];

            List<List<Integer>> ll = diffToElems.getOrDefault(absDiff, new LinkedList<>());
            List<Integer> curr = new LinkedList<>();
            curr.add(arr[i - 1]);
            curr.add(arr[i]);

            ll.add(curr);
            diffToElems.put(absDiff, ll);
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for (int key : diffToElems.keySet()) {
            pq.add(key);
        }

        int smallestDiff = pq.poll();
        List<List<Integer>> res = diffToElems.get(smallestDiff);
        
        return res;
    }
}