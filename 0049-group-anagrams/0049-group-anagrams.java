class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] key = s.toCharArray();
            Arrays.sort(key);

            StringBuilder sbKey = new StringBuilder();
            sbKey.append(key);
            String keyString = sbKey.toString();
            List<String> ll = map.getOrDefault(keyString, new LinkedList<>());
            ll.add(s);
            map.put(keyString, ll);
        }

        List<List<String>> res = new LinkedList<>();
        for (String sKey : map.keySet()) {
            List<String> ll = map.get(sKey);
            res.add(ll);
        }
        return res;
    }
}