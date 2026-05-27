class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Integer, Integer> capMap = new HashMap<>();
        Map<Integer, Queue<Integer>> smallMap = new HashMap<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            boolean isLower = arr[i] >= 97;
            if (isLower) {
                Queue<Integer> q = smallMap.getOrDefault(arr[i], new LinkedList<>());
                q.add(i);
                smallMap.put((int) arr[i], q);
            } else {
                int key = arr[i] + 32;
                if (!capMap.containsKey(key)) {
                    capMap.put(key, i);
                }
            }
        }

        int count = 0;
        for (int key : capMap.keySet()) {
            int capPos = capMap.get(key);
            Queue<Integer> q = smallMap.getOrDefault(key, new LinkedList<>());

            boolean isValid = false;
            while (!q.isEmpty()) {
                int curr = q.poll();
                if (curr < capPos) {
                    isValid = true;
                } else {
                    isValid = false;
                }
            }

            if (isValid) {
                count++;
            }
        }
        return count;
    }
}