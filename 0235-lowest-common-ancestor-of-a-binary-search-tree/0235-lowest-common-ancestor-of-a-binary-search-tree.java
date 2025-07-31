/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    Map<TreeNode, Integer> nodeToLevel = new HashMap<>();
    Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        mapNodesToLevel(root, p, q, 0);
        mapNodeToParent(root, p, q);

        int pLevel = nodeToLevel.get(p);
        int qLevel = nodeToLevel.get(q);

        while (pLevel != qLevel) {
            if (pLevel > qLevel) {
                p = nodeToParent.get(p);
                pLevel--;
            } else {
                q = nodeToParent.get(q);
                qLevel--;
            }
        }

        while (p != q) {
            p = nodeToParent.get(p);
            q = nodeToParent.get(q);
        }
        return p;
    }

    public void mapNodeToParent(TreeNode t, TreeNode p, TreeNode q) {
        if (t == null) {
            return;
        }

        if (nodeToParent.containsKey(p) && nodeToParent.containsKey(q)) {
            return;
        }

        TreeNode left = t.left;
        if (left != null) {
            nodeToParent.put(left, t);
        }

        TreeNode right = t.right;
        if (right != null) {
            nodeToParent.put(right, t);
        }

        mapNodeToParent(t.left, p, q);
        mapNodeToParent(t.right, p, q);
    }

    public void mapNodesToLevel(TreeNode t, TreeNode p, TreeNode q, int level) {
        if (t == null) {
            return;
        }

        if (nodeToLevel.containsKey(p) && nodeToLevel.containsKey(q)) {
            return;
        }

        nodeToLevel.put(t, level);

        int nextLevel = level + 1;
        mapNodesToLevel(t.right, p, q, nextLevel);
        mapNodesToLevel(t.left, p, q, nextLevel);
    }
}