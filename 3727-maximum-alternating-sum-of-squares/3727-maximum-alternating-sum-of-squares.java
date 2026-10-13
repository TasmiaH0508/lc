class Solution {
    /**
    The sign does not matter here. 

    In the optimal array, the bigger in magnitude numbers should be 
    in the even places and the smaller in magnitude numbers should be
    in the odd places. 

    In the naiive way, we can use a pq where we push in the numbers by magnitude and assign them the correct spots. 

    then we compute the sums

    but putting the numbers back isnt really needed?

    create a hashmap of all the magnitudes. 
    */
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        int toSub = nums.length / 2;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < toSub) {
                res -= nums[i];
            } else {
                res += nums[i];
            }
        }
        return res;
    }
}