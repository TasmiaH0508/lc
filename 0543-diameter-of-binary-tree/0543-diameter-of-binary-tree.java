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

    Map<TreeNode, Integer> nodeToMaxEdgesToLeaf = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxEdgesToTreeLeft = getMaxEdgesToLeaf(root.left);
        int maxEdgesToTreeRight = getMaxEdgesToLeaf(root.right);
        int rootDiameter = 2 + maxEdgesToTreeLeft + maxEdgesToTreeRight;

        int maxDiameter = rootDiameter;
        int diameterLeft = diameterOfBinaryTree(root.left);
        int diameterRight = diameterOfBinaryTree(root.right);
        maxDiameter = Math.max(diameterLeft, maxDiameter);
        maxDiameter = Math.max(diameterRight, maxDiameter);
        return maxDiameter;
    }

    public int getMaxEdgesToLeaf(TreeNode t) {
        if (t == null) {
            return -1;
        }

        if (nodeToMaxEdgesToLeaf.containsKey(t)) {
            return nodeToMaxEdgesToLeaf.get(t);
        }

        int maxEdgesLeft = getMaxEdgesToLeaf(t.left);
        int maxEdgesRight = getMaxEdgesToLeaf(t.right);
        int maxEdgesToLeaf = Math.max(maxEdgesLeft, maxEdgesRight) + 1;

        nodeToMaxEdgesToLeaf.put(t, maxEdgesToLeaf);
        return maxEdgesToLeaf;
    }

}