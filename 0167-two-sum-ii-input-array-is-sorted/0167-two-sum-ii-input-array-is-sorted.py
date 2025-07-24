class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        left_index = 1
        right_index = len(numbers)
        while (left_index < right_index):
            left_num = numbers[left_index - 1]
            right_num = numbers[right_index - 1]
            sum_left_right = left_num + right_num
            if sum_left_right == target:
                return [left_index, right_index]
            elif sum_left_right < target:
                left_index += 1
            else:
                right_index -= 1
        