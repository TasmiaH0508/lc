class Solution {
    /**
     * Find all the methods that are directly/indirectly invoked by k. 
     * This will form a group. 
     * 
     * Check if any method outside the group calls any of the functions inside the group. 
     * If there is any such method, then none of the methods can be removed. 
     */
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, List<Integer>> outNeighbours = new HashMap<>();
        for (int[] invocation : invocations) {
            int from = invocation[0];
            int to = invocation[1];

            List<Integer> neighbours = outNeighbours.getOrDefault(from, new LinkedList<>());
            neighbours.add(to);
            outNeighbours.put(from, neighbours);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (visited.contains(curr)) {
                continue;
            }

            visited.add(curr);
            List<Integer> neighbours = outNeighbours.getOrDefault(curr, new LinkedList<>());
            queue.addAll(neighbours);
        }

        boolean isOutsideCalingGroup = false;
        for (int i = 0; i < n && !isOutsideCalingGroup; i++) {
            boolean isInside = visited.contains(i);
            if (isInside) {
                continue;
            }

            List<Integer> ll = outNeighbours.getOrDefault(i, new LinkedList<>());
            for (int l : ll) {
                if (visited.contains(l)) {
                    isOutsideCalingGroup = true;
                    break;
                }
            }
        }

        if (isOutsideCalingGroup) {
            visited.clear();
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}