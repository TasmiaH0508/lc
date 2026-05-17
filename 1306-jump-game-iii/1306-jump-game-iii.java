class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> currStates = new LinkedList<>();
        currStates.add(start);

        Set<Integer> alreadyVisited = new HashSet<>();

        while (!currStates.isEmpty()) {
            int currState = currStates.poll();
            int stepSize = arr[currState];
            alreadyVisited.add(currState);
            
            if (stepSize == 0) {
                return true;
            } 

            int nextState1 = currState - stepSize;
            if (nextState1 >= 0 && !alreadyVisited.contains(nextState1)) {
                currStates.add(nextState1);
            }

            int nextState2 = currState + stepSize;
            if (nextState2 < arr.length && !alreadyVisited.contains(nextState2)) {
                currStates.add(nextState2);
            }
        }

        return false;
    }
}