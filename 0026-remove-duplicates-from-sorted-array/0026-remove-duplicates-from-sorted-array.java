class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curr) {
                count++;
                curr = nums[i];
            }
        }

        curr = nums[0];
        int ptr = 0;
        for (int i = 1; i < count; i++) {
            while (nums[ptr] == curr) {
                ptr++;
            }

            curr = nums[ptr];
            nums[i] = curr;
        }
        return count;
    }
}