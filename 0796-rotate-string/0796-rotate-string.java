class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        Deque<Character> goalDeque = new ArrayDeque<>();
        Deque<Character> sDeque = new ArrayDeque<>();

        char[] goalArr = goal.toCharArray();
        for (char c : goalArr) {
            goalDeque.add(c);
        }

        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            sDeque.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            if (check(goalDeque, sDeque)) {
                return true;
            } else {
                Character first = sDeque.pop();
                sDeque.addLast(first);
            }
        }
        return false;
    }

    private boolean check(Deque<Character> d1, Deque<Character> d2) {
        Object[] d1Arr = d1.toArray();
        Object[] d2Arr = d2.toArray();

        for (int i = 0; i < d1Arr.length; i++) {
            if (!d1Arr[i].equals(d2Arr[i])) {
                return false;
            }
        }
        return true;
    }
}