class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int low = 0;
        int high = people.length - 1;
        int count = 0;
        while (low <= high) {
            if (low == high) {
                count++;
                break;
            }

            int totalWeight = people[low] + people[high];

            if (totalWeight <= limit) {
                count++;
                high--;
                low++;
            } else {
                high--;
                count++;
            }
        }
        return count;
    }
}