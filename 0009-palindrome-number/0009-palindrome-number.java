class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        Queue<Integer> ll = new LinkedList<>();
        while (x > 0) {
            int n = x % 10;
            ll.add(n);
            x /= 10;
        }

        int[] arr = new int[ll.size()];
        int i = 0;
        for (int l : ll) {
            arr[i] = l;
            i++;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] != arr[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}