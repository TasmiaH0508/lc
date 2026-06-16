class Solution {

    public String processStr(String s) {
        char[] arr = s.toCharArray();
        boolean isFront = true; // for reading from front or not

        LinkedList<Character> d = new LinkedList<>();
        for (char c : arr) {
            if (c == '*') {
                if (isFront) {
                    d.pollLast();
                } else {
                    d.pollFirst();
                }
            } else if (c == '#') {
                LinkedList<Character> copy = (LinkedList<Character>) d.clone();
                d.addAll(copy);
            } else if (c == '%') {
                isFront = !isFront;
            } else {
                if (isFront) {
                    d.addLast(c);
                } else {
                    d.addFirst(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) {
            char c;
            if (isFront) {
                c = d.pollFirst();
            } else {
                c = d.pollLast();
            }

            sb.append(c);
        }
        return sb.toString();
    }

}