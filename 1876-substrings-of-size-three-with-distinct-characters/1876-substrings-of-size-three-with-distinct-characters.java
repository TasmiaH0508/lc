class Solution {
    public int countGoodSubstrings(String s) {
        List<List<Character>> ll = new LinkedList<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i + 2 < arr.length; i++) {
            List<Character> l = new LinkedList<>();
            l.add(arr[i]);
            l.add(arr[i + 1]);
            l.add(arr[i + 2]);
            ll.add(l);
        }

        int count = 0;
        for (List<Character> l : ll) {
            if (isGood(l)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGood(List<Character> l) {
        Set<Character> s = new HashSet<>();
        for (Character c : l) {
            s.add(c);
        }
        return s.size() == 3;
    }
}