class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return (nums[0] == target)? 0 : -1;
        }
        int i = 0;
        int j = nums.length - 1;
        int mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        
        mid = (i + j)/2;
        if (nums[mid] == target) {
            return mid;
        }
        return -1;
    }
}