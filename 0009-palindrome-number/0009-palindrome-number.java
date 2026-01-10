class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        Deque<Integer> ll = new ArrayDeque<>();
        while (x > 0) {
            int n = x % 10;
            ll.addLast(n);
            x /= 10;
        }

        while (ll.size() > 0) {
            int front = ll.pollFirst();
            int back = front;
            if (ll.size() > 0) {
                back = ll.pollLast();
            }

            if (front != back) {
                return false;
            }
        }
        return true;
    }
}