class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            sb.append(arr);
            String stringIndex = sb.toString();

            if (map.containsKey(stringIndex)) {
                List<String> ll = map.get(stringIndex);
                ll.add(s);
                map.put(stringIndex, ll);
            } else {
                List<String> ll = new LinkedList<>();
                ll.add(s);
                map.put(stringIndex, ll);
            }
        }

        List<List<String>> res = new LinkedList<>();
        for (String key : map.keySet()) {
            List<String> ll = map.get(key);
            res.add(ll);
        }
        return res;
    }
}