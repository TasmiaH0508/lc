public class Solution {
    public bool IsGood(int[] nums) {
        if (nums.Length == 1)
        {
            return false;
        }

        int n = nums.Length - 1;

        int[] Freq = new int[n];
        foreach (int i in nums)
        {
            if (i > n)
            {
                return false;
            }

            Freq[i - 1]++;
        }

        bool isAppearOnce = true;
        for (int i = 0; i < Freq.Length - 1; i++)
        {
            if (Freq[i] != 1)
            {
                isAppearOnce = false;
            }
        }

        bool isNAppearTwice = Freq[n - 1] == 2;
        return isAppearOnce && isNAppearTwice;
    }
}