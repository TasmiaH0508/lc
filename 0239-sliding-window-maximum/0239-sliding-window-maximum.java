class Solution {
    /**
    For the first window of size k, find the max. This value is max for [0, k).
    If the element is at index i, then potentially, [0, i + k).

    For the sliding windows ending at k, k + 1, k + 2, ..., i + k - 1
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        int windowEnd = k - 1;
        List<Integer> ll = new LinkedList<>();
        ll.add(max);
        while (windowEnd + 1 < nums.length) {
            windowEnd++;

            // check if it can cover...
            boolean canCover = (windowEnd - index + 1) <= k;

            // if can cover and is less than, then add max
            // if can cover but is more than, update max and index
            if (canCover) {
                if (nums[windowEnd] >= max) {
                    max = nums[windowEnd];
                    index = windowEnd;
                }
                ll.add(max);
            } else {
                // find the new max
                int windowStart = index + 1;
                max = Integer.MIN_VALUE;
                for (int i = windowStart; i <= windowEnd; i++) {
                    if (max < nums[i]) {
                        max = nums[i];
                        index = i;
                    }
                }
                ll.add(max);
            }
        }

        int[] res = new int[ll.size()];
        int i = 0;
        for (int l : ll) {
            res[i] = l;
            i++;
        }
        return res;
    }
}