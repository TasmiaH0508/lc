class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int start = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (isStart(nums, mid, target)) {
                // checks 2 conditions: if nums[mid] == target && nums[mid - 1] < target
                start = mid;
                break;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = nums.length - 1;
        int end = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (isEnd(nums, mid, target)) {
                end = mid;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int[] range = new int[]{start, end};
        return range;
    }

    private boolean isEnd(int[] arr, int index, int target) {
        if (arr[index] != target) {
            return false;
        }

        int right = index + 1;
        int rightVal = Integer.MAX_VALUE;
        if (right < arr.length) {
            rightVal = arr[index + 1];
        }

        return rightVal > target;
    }

    private boolean isStart(int[] arr, int index, int target) {
        if (arr[index] != target) {
            return false;
        }

        int left = index - 1;
        int leftVal = Integer.MIN_VALUE;
        if (left >= 0) {
            leftVal = arr[left];
        }

        return leftVal < target;
    }
}