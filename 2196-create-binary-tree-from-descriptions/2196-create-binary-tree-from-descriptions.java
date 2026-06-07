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

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        for (int[] d : descriptions) {
            int val = d[0];
            TreeNode t = new TreeNode(val);
            valToNode.put(val, t);

            int childVal = d[1];
            TreeNode tChild = new TreeNode(childVal);
            valToNode.put(childVal, tChild);
        }

        Set<Integer> childrenVals = new HashSet<>();
        childrenVals.addAll(valToNode.keySet());

        for (int[] d : descriptions) {
            int currNodeVal = d[0];
            int childNodeVal = d[1];
            boolean isLeft = d[2] == 1;

            childrenVals.remove(childNodeVal);

            TreeNode currNode = valToNode.get(currNodeVal);
            TreeNode childNode = valToNode.get(childNodeVal);

            if (isLeft) {
                currNode.left = childNode;
            } else {
                currNode.right = childNode;
            }
        }

        int root = 0;
        for (int key : childrenVals) {
            root = key;
        }

        return valToNode.get(root);
    }

}