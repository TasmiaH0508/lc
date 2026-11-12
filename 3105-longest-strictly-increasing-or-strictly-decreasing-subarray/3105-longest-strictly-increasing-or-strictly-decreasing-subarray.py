class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 1

        is_increasing = nums[0] < nums[1]
        is_decreasing = nums[0] > nums[1]
        max_len = 1
        start = 1
        if is_increasing or is_decreasing:
            max_len = 2
            start = 0

        for i in range(1, len(nums)):
            curr_is_increasing = nums[i - 1] < nums[i]
            curr_is_decreasing = nums[i - 1] > nums[i]

            is_same_direction = (is_increasing and curr_is_increasing) or (is_decreasing and curr_is_decreasing)
            if not is_same_direction:
                is_same_as_prev = not curr_is_increasing and not curr_is_decreasing
                if is_same_as_prev:
                    start = i
                else:
                    start = i - 1

            curr_len = i - start + 1
            max_len = max(curr_len, max_len)
            is_increasing = curr_is_increasing
            is_decreasing = curr_is_decreasing

        return max_len