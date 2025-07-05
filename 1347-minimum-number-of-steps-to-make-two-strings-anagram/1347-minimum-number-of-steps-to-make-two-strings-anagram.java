class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            if (!sMap.containsKey(c)) {
                sMap.put(c, 1);
            } else {
                int f = sMap.get(c);
                f++;
                sMap.put(c, f);
            }
        }
        char[] tArr = t.toCharArray();
        for (char c : tArr) {
            if (!tMap.containsKey(c)) {
                tMap.put(c, 1);
            } else {
                int f = tMap.get(c);
                f++;
                tMap.put(c, f);
            }
        }

        int numChanges = 0;
        for (char c : sMap.keySet()) {
            int numTimesCAppearsInS = sMap.get(c);
            int numTimesCAppearsInT = tMap.getOrDefault(c, 0);
            if (numTimesCAppearsInS > numTimesCAppearsInT) {
                int diff = numTimesCAppearsInS - numTimesCAppearsInT;
                numChanges += diff;
            }
        }
        return numChanges;
    }
}