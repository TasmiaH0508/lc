class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            StringBuilder sb = new StringBuilder();
            sb.append(sArr);

            String key = sb.toString();
            List<String> ll = map.getOrDefault(key, new LinkedList<>());
            ll.add(s);
            map.put(key, ll);
        }

        List<List<String>> res = new LinkedList<>();
        for (String key : map.keySet()) {
            List<String> l = map.get(key);
            res.add(l);
        }
        return res;
    }
}