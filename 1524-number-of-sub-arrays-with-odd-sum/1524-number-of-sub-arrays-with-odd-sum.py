class Solution:
    def numOfSubarrays(self, arr: list[int]) -> int:
        curr_prefix_sum = 0
        prefix_sum_to_freq = {'even': 1, 'odd': 0}

        res = 0
        for i in arr:
            new_prefix_sum = curr_prefix_sum + i

            num_subarrays = prefix_sum_to_freq['even']
            if new_prefix_sum % 2 == 0:
                num_subarrays = prefix_sum_to_freq['odd']

            res += num_subarrays

            if new_prefix_sum % 2 == 0:
                prefix_sum_to_freq['even'] += 1
            else:
                prefix_sum_to_freq['odd'] += 1

            curr_prefix_sum = new_prefix_sum
        
        return res % (10 ** 9 + 7)