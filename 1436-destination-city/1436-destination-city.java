class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> srcDest = new HashMap<>();
        String key = "";
        for (List<String> path : paths) {
            String src = path.get(0);
            String dest = path.get(1);
            srcDest.put(src, dest);

            key = src;
        }

        while (srcDest.containsKey(key)) {
            String next = srcDest.get(key);
            key = next;
        }
        return key;
    }
}