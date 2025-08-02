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

    Map<TreeNode, int[]> nodeToWeight = new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        mapNodesToWeight(root);

        int res = -1;
        while (true) {
            int[] rootWeights = nodeToWeight.get(root);
            int rootPos = rootWeights[0] + 1;

            if (rootPos == k) {
                res = root.val;
                break;
            } else if (rootPos > k) {
                root = root.left;
            } else {
                root = root.right;
                k = k - rootWeights[0] - 1;
            }
        }
        return res;
    }

    public int[] mapNodesToWeight(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (nodeToWeight.containsKey(root)) {
            return nodeToWeight.get(root);
        }

        TreeNode left = root.left;
        int leftWeight = 0;
        if (left != null) {
            int[] leftWeights = mapNodesToWeight(left);
            leftWeight = 1 + leftWeights[0] + leftWeights[1];
        }

        TreeNode right = root.right;
        int rightWeight = 0;
        if (right != null) {
            int[] rightWeights = mapNodesToWeight(right);
            rightWeight = 1 + rightWeights[0] + rightWeights[1];
        }

        int[] weights = new int[]{leftWeight, rightWeight};
        nodeToWeight.put(root, weights);
        return weights;
    }
}