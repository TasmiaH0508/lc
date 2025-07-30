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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null) {
            return false;
        } else if (subRoot == null) {
            return false;
        }

        int rootVal = root.val;
        int subRootVal = subRoot.val;

        if (rootVal != subRootVal) {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        return (isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right)) ||
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }
}