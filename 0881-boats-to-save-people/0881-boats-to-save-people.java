class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0;
        int high = people.length - 1;

        int count = 0;
        while (low <= high) {
            int lowVal = people[low];
            int highVal = people[high];

            count++;
            if (lowVal + highVal <= limit) {
                low++;
                high--;
            } else {
                high--;
            }
        }
        return count;
    }
}