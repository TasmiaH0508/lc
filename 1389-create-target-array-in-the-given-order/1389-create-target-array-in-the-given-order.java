class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> ll = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int ind = index[i];
            ll.add(ind, num);
        }

        int[] res = new int[nums.length];
        int i = 0;
        for (int num : ll) {
            res[i] = num;
            i++;
        }
        return res;
    }
}