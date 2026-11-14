class Solution:
    '''
    Naive:

    - construct all the subarrays of length l to r inclusive. 
    - compute the sums of the l to r elems -> O(l + (l + 1) + ... + r) = O((r + l - 1)/ 2 * (l + r)) in one iteration
    -> but since the sums are not changing -> consider prefix sums -> in one iteration then, r - l lookups have to be made
    - find the minimum sum

    the total cost is then O(n * (r - l))
    '''
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:
        pref = [0]
        for i in range(len(nums)):
            prev = pref[-1]
            pref.append(prev + nums[i])

        min_sum = float('inf')
        for end in range(l, len(pref)):
            start = end - l
            num_iterations = r - l + 1
            for iter in range(num_iterations):
                if start - iter < 0:
                    break

                sum = pref[end] - pref[start - iter]
                if sum > 0:
                    min_sum = min(min_sum, sum)

        if min_sum == float('inf'):
            return -1

        return min_sum