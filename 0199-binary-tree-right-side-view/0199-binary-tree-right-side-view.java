/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Map<Integer, Stack<Integer>> levelToNodes = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {
        groupNodesByLevel(root, 0);

        int level = 0;
        List<Integer> res = new LinkedList<>();
        while (levelToNodes.containsKey(level)) {
            Stack<Integer> s = levelToNodes.get(level);
            int rightmostNodeVal = s.pop();
            res.add(rightmostNodeVal);
            level++;
        }
        return res;
    }

    public void groupNodesByLevel(TreeNode t, int level) {
        if (t == null) {
            return;
        }

        Stack<Integer> s = levelToNodes.getOrDefault(level, new Stack<>());
        s.push(t.val);
        levelToNodes.put(level, s);

        int nextLevel = level + 1;
        groupNodesByLevel(t.left, nextLevel);
        groupNodesByLevel(t.right, nextLevel);
    }
}