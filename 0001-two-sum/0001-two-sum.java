class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Queue<Integer>> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (freqMap.containsKey(num)) {
                Queue<Integer> ll = freqMap.get(num);
                ll.add(i);
                freqMap.put(num, ll);
            } else {
                Queue<Integer> ll = new LinkedList<>();
                ll.add(i);
                freqMap.put(num, ll);
            }
        }

        for (int key : freqMap.keySet()) {
            int needed = target - key;
            Queue<Integer> keyList = freqMap.get(key);
            if (freqMap.containsKey(needed)) {
                if (needed == key && keyList.size() >= 2) {
                    int index1 = keyList.poll();
                    int index2 = keyList.poll();
                    return new int[]{index1, index2};
                }

                if (needed != key) {
                    int index1 = keyList.poll();
                    Queue<Integer> ll = freqMap.get(needed);
                    int index2 = ll.poll();
                    return new int[]{index1, index2};
                }
            }
        }

        return null;
    }
}