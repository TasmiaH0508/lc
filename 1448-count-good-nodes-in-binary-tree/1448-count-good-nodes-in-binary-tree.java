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
    public int goodNodes(TreeNode root) {
        int minVal = root.val;
        return goodNodes(root, minVal);
    }

    public int goodNodes(TreeNode root, int minVal) {
        if (root == null) {
            return 0;
        }

        if (root.val < minVal) {
            return goodNodes(root.left, minVal) + goodNodes(root.right, minVal);
        }

        minVal = root.val;
        return 1 + goodNodes(root.left, minVal) + goodNodes(root.right, minVal);
    }
}