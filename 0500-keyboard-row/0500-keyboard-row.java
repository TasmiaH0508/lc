class Solution {
    public String[] findWords(String[] words) {
        int[] letterToRow = new int[26];

        // second row chars
        char[] secondRow = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        for (char a : secondRow) {
            letterToRow[a - 'a'] = 1;
        }

        // third row
        char[] thirdRow = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        for (char a : thirdRow) {
            letterToRow[a - 'a'] = 2;
        }

        List<String> ll = new ArrayList<>();
        for (String w : words) {
            String wLc = w.toLowerCase();
            char[] arr = wLc.toCharArray();

            int indexFirstChar = letterToRow[arr[0] - 'a'];
            boolean sameRow = true;
            for (int i = 1; i < arr.length; i++) {
                if (letterToRow[arr[i] - 'a'] != indexFirstChar) {
                    sameRow = false;
                    break;
                }
            }

            if (sameRow) {
                ll.add(w);
            }
        }

        String[] res = new String[ll.size()];
        int j = 0;
        for (String s : ll) {
            res[j] = s;
            j++;
        }
        return res;
    }
}