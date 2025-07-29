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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthOfLeftSubtree = maxDepth(root.left);
        int depthOfRightSubtree = maxDepth(root.right);
        int maxDepth = Math.max(depthOfLeftSubtree, depthOfRightSubtree) + 1;
        return maxDepth;
    }
}