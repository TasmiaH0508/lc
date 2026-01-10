class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> elems1 = new HashSet<>();
        for (int num : nums1) {
            elems1.add(num);
        }

        Set<Integer> rep = new HashSet<>();
        for (int num : nums2) {
            if (elems1.contains(num)) {
                rep.add(num);
            }
        }

        int[] res = new int[rep.size()];
        int i = 0;
        for (int r : rep) {
            res[i] = r;
            i++;
        }
        return res;
    }
}