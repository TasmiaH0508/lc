public class Solution {
    public bool ContainsDuplicate(int[] nums)
    {
        Dictionary<int, int> freq = new Dictionary<int, int>();
        foreach (int n in nums)
        {
            if (freq.ContainsKey(n))
            {
                int currF = freq[n];
                freq[n] = currF + 1;
            } else
            {
                freq[n] = 1;
            }
        }

        foreach (int key in freq.Keys)
        {
            int val = freq[key];
            if (val >= 2)
            {
                return true;
            }
        }

        return false;
    }
}